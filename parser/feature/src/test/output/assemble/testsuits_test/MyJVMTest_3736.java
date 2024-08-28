import java.io.*;

public class MyJVMTest_3736 {

    static ObjectOutput out = null;

    static LSI lamb = null;

    static LSI cisi = null;

    static LSI iisi = null;

    ObjectOutput write(ObjectOutput out, LSI lamb) throws IOException {
        out.writeObject(lamb);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3736().write(out, lamb);
    }
}
