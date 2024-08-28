import java.io.*;

public class MyJVMTest_16723 {

    static ObjectInput in = null;

    static int i = 3;

    static float f = Float.NEGATIVE_INFINITY;

    ObjectInput readExternal(ObjectInput in) throws IOException {
        i = in.readInt();
        f = in.readFloat();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16723().readExternal(in);
    }
}
