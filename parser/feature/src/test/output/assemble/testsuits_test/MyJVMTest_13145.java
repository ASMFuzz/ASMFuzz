import java.io.*;

public class MyJVMTest_13145 {

    static ObjectInputStream ois = new ObjectInputStream();

    @SuppressWarnings("serial")
    static String[] serialPersistentFields = { "Foo", "Foobar" };

    static Integer field1 = -183542254;

    static double field2 = Double.NaN;

    static int field3 = 5;

    static String field4 = "fhuv0(_K6k";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", Integer.valueOf(100));
        field2 = pfields.get("field2", 99.99);
        field3 = pfields.get("field3", 99);
        field4 = (String) pfields.get("field4", "Default string");
        try {
            String[] tserialPersistentFields = (String[]) pfields.get("serialPersistentFields", null);
            System.out.println("Passes test 3");
        } catch (IllegalArgumentException e) {
            throw new Error("non-static field:  " + "serialPersistentFields must be in the persistent stream");
        }
        return pfields;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13145().readObject(ois);
    }
}
