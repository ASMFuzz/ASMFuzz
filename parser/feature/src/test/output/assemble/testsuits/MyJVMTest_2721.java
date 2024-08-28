import java.io.*;

public class MyJVMTest_2721 {

    Object getObject() throws Exception {
        ObjectStreamClass osc = ObjectStreamClass.lookup(SerializableObject.class);
        SerializableObject initObj = (SerializableObject) osc.forClass().newInstance();
        return initObj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2721().getObject());
    }
}
