import java.io.*;

public class MyJVMTest_17190 {

    static int outParam1Param1 = 499;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static ObjectOutputStream out = new ObjectOutputStream(outParam1);

    static int i = 1;

    static float f = Float.NEGATIVE_INFINITY;

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(i);
        out.writeFloat(f);
        out.writeUTF("skip me");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17190().writeObject(out);
    }
}
