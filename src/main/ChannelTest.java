package main;

import com.jayway.jsonpath.JsonPath;
import paas.Channel;

import java.util.HashMap;

public class ChannelTest {
    // 频道对象
    private static Channel channelObj;

    public static void main(String [] params)
    {
        try {
            HashMap config = Config.getConfig();

            // 频道对象
            channelObj = new Channel(config);

            testCreate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 创建频道演示
    public static void testCreate() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        // 调用sdk 创建 方法
        String resultCreate = channelObj.create(paramCreate);

        // 获取返回值中的房间ID（包内已加载JsonPath，可直接引用）
        String channelId = JsonPath.read(resultCreate, "$.data.channel_id");

        // 打印服务器返回结果
        channelObj.dump(resultCreate);
        channelObj.dump(channelId);
    }
}
