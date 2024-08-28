import java.io.*;

public class MyJVMTest_10333 {

    static ObjectInputStream ois = new ObjectInputStream();

    static String[] serialPersistentFields = { "Foo", "Foobar" };

    static Integer field1 = 2;

    static double field2 = Double.MAX_VALUE;

    static int field3 = 1932685466;

    static String field4 = "u[&70#6+fw";

    ObjectInputStream.GetField readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField pfields = ois.readFields();
        field1 = (Integer) pfields.get("field1", new Integer(100));
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
        new MyJVMTest_10333().readObject(ois);
    }
}
