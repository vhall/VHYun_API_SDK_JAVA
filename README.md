# VHYun WEB API SDK implement with JAVA
[![Software License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](LICENSE)

## 安装&使用
* 项目开始前，请确保已经申请了app_id 和 secret_key 否则得到一个应用ID不能为空的异常
* 下载项目目录下 libs/paas_api_sdk_main_1.0.jar 文件，引入项目，加载为Libary
* 参数统一为HashMap<String, Object> 结构
* 项目添加了jsonPath包，可以直接按path取值
* SDK实现了所有微吼API方法，具体方法请参见 paas_api_sdk_main_1.0.jar -> paas/*
* SDK中方法和API中方法一一对应，由于方法中无法使用横线(-)遇到横线的API统一替换成驼峰命名方法（eg: hello-world -> helloWord）

## 示例：使用方法

### 创建房间 http://www.vhallyun.com/document/detail/index?project_id=40&doc_id=1015
```java
package main;

import paas.Room;

import java.util.HashMap;

public class RoomTest {
    private static Room roomObj;


    public static void main(String [] params)
    {
        try {
            // 获取基础参数
            HashMap<String, Object> configMap = new HashMap<String, Object>();
            
            // app_id secret_key 具体参见 ： http://www.vhallyun.com/document/detail/index?project_id=35&doc_id=843#应用ID（app_id）是什么？
            configMap.put("app_id", "xxxxxxxxxx");
            configMap.put("secret_key", "xxxxxxxxxx");
            // 实例化房间对象
            roomObj = new Room(configMap);
            
            // 测试创建房间
            testCreate();

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void testCreate() throws Exception
    {
        // 创建房间参数
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        
        // 调用创建房间方法
        String resultCreate = roomObj.create(paramCreate);
        
        // 打印服务器返回结果
        roomObj.dump(resultCreate);
    }
}

```

### 创建文档 http://www.vhallyun.com/document/detail/index?project_id=40&doc_id=1045

```java
package main;
import paas.Document;
import java.io.File;
import java.util.HashMap;

public class DocumentTest {
    private static Document documentObj;

    public static void main(String [] params)
    {
        try {
            // 获取基础参数
            HashMap<String, Object> configMap = new HashMap<String, Object>();
            
            // app_id secret_key 具体参见 ： http://www.vhallyun.com/document/detail/index?project_id=35&doc_id=843#应用ID（app_id）是什么？
            configMap.put("app_id", "xxxxxxxxxx");
            configMap.put("secret_key", "xxxxxxxxxx");
            
            // 实例化文档对象
            documentObj = new Document(configMap);

            // 创建文档测试
            testCreate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testCreate() throws Exception
    {
        // 创建文档参数
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        
        // 文档参数中所需要的文档的具体资源路径（绝对路径）
        paramCreate.put("document", new File("").getAbsolutePath() + "/resources/number.pptx");
        
        // 调用创建房间方法
        String resultCreate = documentObj.create(paramCreate);

        // 打印服务器返回值
        documentObj.dump(resultCreate);
    }
}
```

* 更多使用实例请参见 src/main/*

## 常见问题
- 文件不存在，请确保上传的封面文件路径是否正确。
- SDK的使用 demo 可以参考 (https://github.com/vhall/web_sdk_java/src/main/*)。
- 该SDK请和微吼云API配合使用，具体使用参数请参考(http://www.vhallyun.com/document/detail/index?project_id=40&doc_id=952)。


## 联系我们

- 如果需要帮助，请提交工单（直接向 yue.song@vhall.com 发送邮件）
- 更详细的文档，见[官方文档站](http://www.vhallyun.com/document/detail/index?project_id=40&doc_id=952)
- 如果发现了bug， 欢迎提交 [issue](https://github.com/vhall/VHYun_API_SDK_JAVA/issues)
- 如果有功能需求，欢迎提交 [issue](https://github.com/vhall/VHYun_API_SDK_JAVA/issues)

## 代码许可

The MIT License (MIT)
