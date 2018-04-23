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

        configMap.put("app_id", "342a10bb");
        configMap.put("secret_key", "7b887d97f11cb1f7c6cb890fbecf0367");
        //configMap.put("request_domain", "http://api.vhallyun.com/api/v1");

        return configMap;
    }

}
