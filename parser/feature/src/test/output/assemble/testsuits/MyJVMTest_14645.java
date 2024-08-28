import java.io.*;

public class MyJVMTest_14645 {

    static ObjectOutput out = null;

    ObjectOutput writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(0);
        out.close();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14645().writeExternal(out);
    }
}
