以下是生成签名类

```java
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class SignTest {

    private static String secretKey = "";
    
    public static void main(String [] params)
    {
        secretKey = "xxxxx";
        // 参数
        HashMap<String, Object> param = new HashMap<>();
        param.put("document_id", "xxxxx");
        param.put("app_id", "xxxx");
        // 生成签名
        String sign = Signature(param);
        
        System.out.println("签名字符串是" + sign);
    }

    // 生成签名文件
    public static String Signature(HashMap<String, Object> param)
    {
        param.put("signed_at", toString(new Date().getTime()).substring(0, 10));
        TreeMap treeMap = new TreeMap(param);
        String signatrue = secretKey;

        for(Object o : treeMap.keySet()) {
            // 文件签名忽略
            if (o.toString().equals("document")) continue;

            signatrue = signatrue + o.toString() + treeMap.get(o).toString();
        }

        signatrue = signatrue + secretKey;
        System.out.println(signatrue + "\n");
        return parseMd5(signatrue);
    }

    public static String parseMd5(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return reStr;
    }

    public static String toString(Object o)
    {
        String str = o.toString();

        return str;
    }
}

```