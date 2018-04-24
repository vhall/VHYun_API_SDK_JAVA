package main;

import com.jayway.jsonpath.JsonPath;
import paas.Download;
import paas.Record;
import paas.Room;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DownloadTest {
    // 下载对象
    private static Download downloadObj;

    // 配置文件对象
    private static HashMap config;

    // 房间ID
    private static String room_id;

    public static void main(String [] params)
    {
        try {
            config = Config.getConfig();

            // 下载对象
            downloadObj = new Download(config);

            testPreToDownload();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 按清晰度生成下载演示
    public static void testPreToDownload() throws Exception
    {
        /**
         * 构建参数，方便测试，这里只生产参数
         * 产环境需要有实际发起直播流程，否则无法生成具体下载文件
         */
        HashMap<String, Object> paramPreToDownload = new HashMap<String, Object>();

        Room roomObj = new Room(config);
        // 调用sdk 创建 方法
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        String resultCreate = roomObj.create(paramCreate);

        // 获取返回值中的房间ID（包内已加载JsonPath，可直接引用）
        String room_id = JsonPath.read(resultCreate, "$.data.room_id");
        paramCreate.put("room_id", room_id);

        // 这里举例子取前10分钟的视频
        Calendar LastTentime = Calendar.getInstance();
        LastTentime.add(Calendar.MINUTE, -10);

        paramCreate.put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LastTentime.getTime()));
        paramCreate.put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));

        // 调用sdk 中创建方法
        Record recordObj = new Record(config);
        String resultCreateRecord = recordObj.create(paramCreate);

        // 获取回放ID
        String recordId = JsonPath.read(resultCreateRecord, "$.data.record_id");

        paramPreToDownload.put("record_id", recordId);
        paramPreToDownload.put("rate", "360P");

        // 调用按清晰度生成下载方法
        String resultPreToDownload =  downloadObj.preToDownload(paramPreToDownload);

        downloadObj.dump(resultPreToDownload);
    }

}
