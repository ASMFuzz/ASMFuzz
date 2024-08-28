import java.io.*;

public class MyJVMTest_14803 {

    static ObjectInputStream ois = new ObjectInputStream();

    static Integer field1 = 0;

    static double field2 = 0d;

    static int field3 = 9;

    static String field4 = "R6,7J\"7/}1";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", Integer.valueOf(100));
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
        new MyJVMTest_14803().readObject(ois);
    }
}
