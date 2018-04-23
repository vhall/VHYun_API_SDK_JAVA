package main;

import java.util.HashMap;

public class Config {

    /**
     * 获取当前配置文件
     * @return
     */
    public static HashMap getConfig()
    {
        HashMap<String, Object> configMap = new HashMap<String, Object>();

        configMap.put("app_id", "xxxxxxxxxx");
        configMap.put("secret_key", "xxxxxxxxxxxxx");
        //configMap.put("request_domain", "http://api.vhallyun.com/api/v1");

        return configMap;
    }

}
