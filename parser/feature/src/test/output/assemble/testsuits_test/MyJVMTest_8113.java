import java.io.*;

public class MyJVMTest_8113 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        ITargetName resist = () -> "fubar";
        out.writeObject(resist);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8113().write(out);
    }
}
