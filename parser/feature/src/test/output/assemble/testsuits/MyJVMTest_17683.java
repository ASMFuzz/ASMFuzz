import java.io.*;

public class MyJVMTest_17683 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        ITargetName resist = () -> "fubar";
        out.writeObject(resist);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17683().write(out);
    }
}
