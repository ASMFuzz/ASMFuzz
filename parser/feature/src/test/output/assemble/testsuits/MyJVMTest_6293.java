import java.io.*;

public class MyJVMTest_6293 {

    static byte[] oisParam1Param1 = { -112, 65, 29, 22, 87, -87, 41, 33, 41, 47 };

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = 2;

    static double field2 = Double.NaN;

    static int field3 = 1;

    static String field4 = "0R7^ Q'^X*";

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
        new MyJVMTest_6293().readObject(ois);
    }
}
