import java.io.*;

public class MyJVMTest_15720 {

    static byte[] oisParam1Param1 = { -126, 63, 127, 85, 89, -114, 114, 101, -37, 97 };

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = 7;

    static double field2 = Double.NaN;

    static int field3 = 2;

    static String field4 = "%&PE:1j_m7";

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
        new MyJVMTest_15720().readObject(ois);
    }
}
