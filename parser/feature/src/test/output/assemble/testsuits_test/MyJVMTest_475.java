import java.io.*;

public class MyJVMTest_475 {

    static byte[] oisParam1Param1 = { -38, -21, -59, 98, -127, -25, 98, -10, -38, -28 };

    static int oisParam1Param2 = 795;

    static int oisParam1Param3 = 855;

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1, oisParam1Param2, oisParam1Param3);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = 0;

    static double field2 = 0.34795382518146656;

    static int field3 = -2083376277;

    static String field4 = "[^(pk*u`.T";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", new Integer(100));
        field2 = pfields.get("field2", 99.99);
        try {
            field3 = pfields.get("field3", 99);
            System.out.println("Passes test 2a");
        } catch (IllegalArgumentException e) {
            throw new Error("data field: field3 not in the persistent stream");
        }
        try {
            field4 = (String) pfields.get("field4", "Default string");
            System.out.println("Passes test 2b");
        } catch (IllegalArgumentException e) {
            throw new Error("data field: field4 not in the persistent stream");
        }
        return pfields;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_475().readObject(ois);
    }
}
