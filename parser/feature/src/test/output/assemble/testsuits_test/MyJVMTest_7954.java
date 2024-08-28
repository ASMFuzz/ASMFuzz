import java.io.*;

public class MyJVMTest_7954 {

    static ObjectOutput out = null;

    static int i = -1256068512;

    static float f = Float.MIN_VALUE;

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(i);
        out.writeFloat(f);
        out.writeUTF("skip another");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7954().writeExternal(out);
    }
}
