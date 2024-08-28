import java.io.*;
import java.util.function.*;

public class MyJVMTest_15089 {

    static ObjectInput in = null;

    ObjectInput readCheck(ObjectInput in) throws Exception {
        in.readObject();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15089().readCheck(in);
    }
}
