package main;

import com.jayway.jsonpath.JsonPath;
import paas.Room;

import java.util.HashMap;

public class RoomTest {
    // 房间对象
    private static Room roomObj;

    // 房间ID
    private static String room_id;

    public static void main(String [] params)
    {
        try {
            HashMap config = Config.getConfig();

            // 房间对象
            roomObj = new Room(config);

            testCreate();
            testDelete();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 创建房间演示
    public static void testCreate() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        // 调用sdk 创建 方法
        String resultCreate = roomObj.create(paramCreate);

        // 获取返回值中的房间ID（包内已加载JsonPath，可直接引用）
        room_id = JsonPath.read(resultCreate, "$.data.room_id");

        // 打印服务器返回结果
        roomObj.dump(resultCreate);
    }

    // 删除房间演示
    public static void testDelete() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        paramCreate.put("room_id", room_id);

        // 调用sdk 删除 方法
        String resultCreate = roomObj.delete(paramCreate);

        // 打印服务器返回结果
        roomObj.dump(resultCreate);
    }
}
