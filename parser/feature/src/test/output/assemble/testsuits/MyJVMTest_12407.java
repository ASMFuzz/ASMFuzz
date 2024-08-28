import java.io.*;

public class MyJVMTest_12407 {

    static ObjectOutputStream out = new ObjectOutputStream();

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        throw new OutOfMemoryError();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12407().writeObject(out);
    }
}
