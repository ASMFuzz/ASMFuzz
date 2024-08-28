import java.io.*;

public class MyJVMTest_10836 {

    static ObjectInput in = null;

    ObjectInput readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readInt();
        in.close();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10836().readExternal(in);
    }
}
