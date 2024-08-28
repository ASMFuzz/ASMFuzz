import java.io.*;

public class MyJVMTest_8272 {

    static ObjectInput in = null;

    ObjectInput readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
        throw new ClassNotFoundException();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8272().readExternal(in);
    }
}
