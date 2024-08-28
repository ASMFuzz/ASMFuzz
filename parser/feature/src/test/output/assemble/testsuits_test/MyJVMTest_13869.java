import java.io.*;

public class MyJVMTest_13869 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        String a = "fu";
        String b = "bar";
        IOrderOfCapturedArgs res = () -> b + a;
        out.writeObject(res);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13869().write(out);
    }
}
