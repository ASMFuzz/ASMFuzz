import java.io.*;
import java.util.function.*;

public class MyJVMTest_5653 {

    static ObjectInput in = null;

    ObjectInput readCheck(ObjectInput in) throws Exception {
        in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5653().readCheck(in);
    }
}
