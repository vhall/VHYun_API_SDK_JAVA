package main;

import com.jayway.jsonpath.JsonPath;
import paas.Base;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class BaseTest {
    // 基础对象（用户移动端SDK）
    private static Base baseObj;

    // 配置文件对象
    private static HashMap config;


    public static void main(String [] params)
    {
        try {
            config = Config.getConfig();

            // 下载对象
            baseObj = new Base(config);

            testCreateAccessToken();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 按清晰度生成下载演示
    public static void testCreateAccessToken() throws Exception
    {
        HashMap<String, Object> paramCreateAccessToken = new HashMap<String, Object>();
        paramCreateAccessToken.put("third_party_user_id", "third_party_user_id");

        String resultAccessToken = baseObj.createAccessToken(paramCreateAccessToken);

        baseObj.dump(resultAccessToken);
    }

}
