import java.io.*;

public class MyJVMTest_7200 {

    static ObjectInput in = null;

    static int i = -1521928211;

    static float f = Float.NEGATIVE_INFINITY;

    ObjectInput readExternal(ObjectInput in) throws IOException {
        i = in.readInt();
        f = in.readFloat();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7200().readExternal(in);
    }
}
