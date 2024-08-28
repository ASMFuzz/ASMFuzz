import java.io.*;

public class MyJVMTest_3095 {

    static int outParam1Param1 = 740;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static ObjectOutputStream out = new ObjectOutputStream(outParam1);

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        throw new OutOfMemoryError();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3095().writeObject(out);
    }
}
