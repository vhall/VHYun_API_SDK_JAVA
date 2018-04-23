package main;

import paas.Room;

import java.util.HashMap;

public class RoomTest {
    private static Room roomObj;


    public static void main(String [] params)
    {
        try {
            HashMap config = Config.getConfig();
            roomObj = new Room(config);


            testCreate();

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void testCreate() throws Exception
    {
        HashMap<String, Object> paramCreate = new HashMap<String, Object>();
        String resultCreate = roomObj.create(paramCreate);

        roomObj.dump(resultCreate);
    }
}
