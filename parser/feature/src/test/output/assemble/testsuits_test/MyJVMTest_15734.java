import java.io.*;
import java.security.cert.*;

public class MyJVMTest_15734 {

    String getName() {
        return "CTOR Test (by encoding, unknown explicit tag)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15734().getName());
    }
}
