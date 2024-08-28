import java.io.*;
import java.security.cert.*;

public class MyJVMTest_13208 {

    String getName() {
        return "Simple Equality Test";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13208().getName());
    }
}
