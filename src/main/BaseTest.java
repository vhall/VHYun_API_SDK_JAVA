package main;

import com.jayway.jsonpath.JsonPath;
import paas.Base;
import paas.Channel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class BaseTest {
    // 基础对象（用户移动端SDK）
    private static Base baseObj;

    // 配置文件对象
    private static HashMap config;


    public static void main(String [] params)
    {
        try {
            config = Config.getConfig();

            // 基础对象
            baseObj = new Base(config);

            testCreateAccessToken();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 生成accessToken 演示
    public static void testCreateAccessToken() throws Exception
    {
        HashMap<String, Object> paramCreateAccessToken = new HashMap<String, Object>();

        Integer randUser = new Random().nextInt(10000);
        paramCreateAccessToken.put("third_party_user_id", "third_party_user_id:" + randUser);

        // 这里过期设置设置为10个小时
        Calendar LastTenHourtime = Calendar.getInstance();
        LastTenHourtime.add(Calendar.HOUR, +10);

        paramCreateAccessToken.put("expire_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LastTenHourtime.getTime()));

        // 这里举例子给 聊天权限
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();

        // 调用sdk 创建 方法
        String resultCreate = new Channel(config).create(paramCreate);

        // 获取返回值中的房间ID（包内已加载JsonPath，可直接引用）
        String channelId = JsonPath.read(resultCreate, "$.data.channel_id");

        paramCreateAccessToken.put("chat", channelId);

        // 调用方法
        String resultAccessToken = baseObj.createAccessToken(paramCreateAccessToken);

        baseObj.dump(resultAccessToken);
    }
}
