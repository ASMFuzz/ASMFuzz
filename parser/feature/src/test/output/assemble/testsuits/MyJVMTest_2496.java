import java.io.*;

public class MyJVMTest_2496 {

    static ObjectOutputStream out = new ObjectOutputStream();

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.close();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2496().writeObject(out);
    }
}
