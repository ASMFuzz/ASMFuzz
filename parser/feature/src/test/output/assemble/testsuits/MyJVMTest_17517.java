import java.io.*;

public class MyJVMTest_17517 {

    static ObjectOutput out = null;

    static int i = -1337909408;

    static float f = Float.POSITIVE_INFINITY;

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(i);
        out.writeFloat(f);
        out.writeUTF("skip another");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17517().writeExternal(out);
    }
}
