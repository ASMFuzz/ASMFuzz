import java.io.*;
import java.security.cert.*;

public class MyJVMTest_884 {

    String getName() {
        return "CTOR Test (by-name)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_884().getName());
    }
}
