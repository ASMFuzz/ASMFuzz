import java.io.*;

public class MyJVMTest_6246 {

    static byte[] oisParam1Param1 = { -18, -32, -30, -75, -54, 12, -17, -110, 53, -63 };

    static int oisParam1Param2 = 703;

    static int oisParam1Param3 = 941;

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1, oisParam1Param2, oisParam1Param3);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = -817412093;

    static double field2 = 0.21462999979514263;

    static int field3 = 3;

    static String field4 = "S._&Q=nJ'|";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", Integer.valueOf(100));
        field2 = pfields.get("field2", 99.99);
        try {
            field3 = pfields.get("field3", 99);
            System.out.println("Passes test 1a");
        } catch (IllegalArgumentException e) {
            throw new Error("data field: field3 not in the persistent stream");
        }
        try {
            field4 = (String) pfields.get("field4", "Default string");
            System.out.println("Passes test 1b");
        } catch (IllegalArgumentException e) {
            throw new Error("data field: field4 not in the persistent stream");
        }
        return pfields;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6246().readObject(ois);
    }
}
