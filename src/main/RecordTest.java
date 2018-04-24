package main;

import com.jayway.jsonpath.JsonPath;
import paas.Record;
import paas.Room;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class RecordTest {
    // 点播对象
    private static Record recordObj;

    // 配置文件对象
    private static HashMap config;

    public static void main(String [] params)
    {
        try {
            config = Config.getConfig();

            // 房间对象
            recordObj = new Record(config);

            testCreate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 创建房间演示
    public static void testCreate() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();

        /**
         * 获取创建点播参数 房间ID
         * 注意 ： 实际场景中，房间在创建好后需要直播在调用，这里为流程完成使用sdk 直接创建房间ID
         */
        Room roomObj = new Room(config);
        // 调用sdk 创建 方法
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
        String resultCreateRecord = recordObj.create(paramCreate);

        // 打印服务器返回结果
        recordObj.dump(resultCreateRecord);
    }

}
