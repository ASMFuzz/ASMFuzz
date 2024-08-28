import java.io.*;

public class MyJVMTest_1646 {

    static ObjectOutput out = null;

    static LSI lamb = null;

    ObjectOutput write(ObjectOutput out, LSI lamb) throws IOException {
        out.writeObject(lamb);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1646().write(out, lamb);
    }
}
