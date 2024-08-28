import java.io.*;

public class MyJVMTest_15771 {

    static byte[] oisParam1Param1 = { -21, 108, 15, 104, -10, -32, 61, 113, 76, -40 };

    static int oisParam1Param2 = 838;

    static int oisParam1Param3 = 317;

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1, oisParam1Param2, oisParam1Param3);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = 8;

    static double field2 = 0.7368182825435833;

    static int field3 = 1976645920;

    static String field4 = "A5\\;ss,*WW";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", new Integer(100));
        field2 = pfields.get("field2", 99.99);
        try {
            field3 = pfields.get("field3", 99);
            throw new Error("data field: field3 in the persistent stream");
        } catch (IllegalArgumentException e) {
            System.out.println("Passes test 4a");
        }
        try {
            field4 = (String) pfields.get("field4", "Default string");
            throw new Error("data field: field4 in the persistent stream");
        } catch (IllegalArgumentException e) {
            System.out.println("Passes test 4b");
        }
        return pfields;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15771().readObject(ois);
    }
}
