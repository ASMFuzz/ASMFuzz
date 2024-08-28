import java.io.*;

public class MyJVMTest_13919 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        Object x = "hi";
        ITypesOfCapturedArgs res = () -> x;
        out.writeObject(res);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13919().write(out);
    }
}
