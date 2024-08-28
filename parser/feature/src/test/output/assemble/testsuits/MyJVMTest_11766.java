import java.io.*;

public class MyJVMTest_11766 {

    static int outParam1Param1 = 895;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static ObjectOutputStream out = new ObjectOutputStream(outParam1);

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.close();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11766().writeObject(out);
    }
}
