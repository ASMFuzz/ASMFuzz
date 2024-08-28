import java.io.*;

public class MyJVMTest_12244 {

    static byte[] oisParam1Param1 = { 112, -106, 17, -120, 84, 22, 21, -108, -40, -31 };

    static int oisParam1Param2 = 725;

    static int oisParam1Param3 = 659;

    static InputStream oisParam1 = new ByteArrayInputStream(oisParam1Param1, oisParam1Param2, oisParam1Param3);

    static ObjectInputStream ois = new ObjectInputStream(oisParam1);

    static Integer field1 = 8;

    static double field2 = Double.MAX_VALUE;

    static int field3 = -532832427;

    static String field4 = "S41[Xg n=j";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", new Integer(100));
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
        new MyJVMTest_12244().readObject(ois);
    }
}
