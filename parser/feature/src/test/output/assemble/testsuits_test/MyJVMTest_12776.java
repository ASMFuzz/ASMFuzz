import java.io.*;
import java.security.cert.*;

public class MyJVMTest_12776 {

    String getName() {
        return "CTOR Test (by-keyID)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12776().getName());
    }
}
