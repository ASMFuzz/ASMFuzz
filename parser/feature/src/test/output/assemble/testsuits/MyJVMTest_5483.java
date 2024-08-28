import java.io.*;

public class MyJVMTest_5483 {

    static byte[] oisParam1Param1 = { -106, -124, -117, 46, 87, -20, 10, 89, 1, 78 };

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = 0;

    static double field2 = 0d;

    static int field3 = 5;

    static String field4 = ",;%|t?sYRA";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", Integer.valueOf(100));
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
        new MyJVMTest_5483().readObject(ois);
    }
}
