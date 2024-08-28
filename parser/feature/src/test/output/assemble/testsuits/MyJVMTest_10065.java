import java.io.*;
import java.security.cert.*;

public class MyJVMTest_10065 {

    String getName() {
        return "CTOR Test (by-name)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10065().getName());
    }
}
