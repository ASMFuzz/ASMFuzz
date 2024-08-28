import java.io.*;

public class MyJVMTest_12506 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        int y = 44;
        INameOfCapturedArgs res = () -> y;
        out.writeObject(res);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12506().write(out);
    }
}
