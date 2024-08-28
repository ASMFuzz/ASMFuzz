import java.io.*;

public class MyJVMTest_7641 {

    static int outParam1Param1 = 882;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static ObjectOutputStream out = new ObjectOutputStream(outParam1);

    static int i = 3;

    static float f = Float.NaN;

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(i);
        out.writeFloat(f);
        out.writeUTF("skip me");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7641().writeObject(out);
    }
}
