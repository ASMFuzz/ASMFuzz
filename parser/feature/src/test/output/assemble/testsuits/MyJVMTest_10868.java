import java.io.*;

public class MyJVMTest_10868 {

    static ObjectOutput out = null;

    static LSI lamb = null;

    ObjectOutput write(ObjectOutput out, LSI lamb) throws IOException {
        out.writeObject(lamb);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10868().write(out, lamb);
    }
}
