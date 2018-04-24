package main;

import paas.Document;

import java.io.File;
import java.util.HashMap;

public class DocumentTest {
    private static Document documentObj;

    public static void main(String [] params)
    {
        try {
            HashMap config = Config.getConfig();
            // 文档对象
            documentObj = new Document(config);
            testCreate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 创建文档演示
    public static void testCreate() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();

        // 创建文档参数，使用文档绝对路径
        paramCreate.put("document", new File("").getAbsolutePath() + "/resources/number.pptx");

        // 调用sdk 创建 方法
        String resultCreate = documentObj.create(paramCreate);

        // 打印服务器返回结果
        documentObj.dump(resultCreate);
    }
}
