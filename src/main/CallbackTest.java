package main;

import paas.Callback;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CallbackTest {
    // 频道对象
    private static Callback callbackObj;

    public static void main(String [] params)
    {
        try {
            HashMap config = Config.getConfig();

            // 回调对象
            callbackObj = new Callback(config);

            testFailList();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 查询回调失败记录演示
    public static void testFailList() throws Exception
    {
        HashMap<String, Object> paramFailList = new HashMap<String, Object>();

        // 具体回调事件请参见回调说明
        paramFailList.put("event", "record/trans-over");

        // 按时间情况填写时间
        paramFailList.put("start_time", new SimpleDateFormat().format(new Date().getTime()));

        // 调用回调失败记录接口
        String resultFailList = callbackObj.failList(paramFailList);

        callbackObj.dump(resultFailList);
    }


}
