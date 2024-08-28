import java.io.*;

public class MyJVMTest_3189 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        int y = 44;
        INameOfCapturedArgs res = () -> y;
        out.writeObject(res);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3189().write(out);
    }
}
