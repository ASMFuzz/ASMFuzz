import java.io.*;

public class MyJVMTest_4482 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        String a = "fu";
        String b = "bar";
        IOrderOfCapturedArgs res = () -> b + a;
        out.writeObject(res);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4482().write(out);
    }
}
