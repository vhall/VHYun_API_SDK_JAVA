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
            documentObj = new Document(config);
            testCreate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testCreate() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        paramCreate.put("document", new File("").getAbsolutePath() + "/resources/number.pptx");
        String resultCreate = documentObj.create(paramCreate);

        documentObj.dump(resultCreate);
    }
}
