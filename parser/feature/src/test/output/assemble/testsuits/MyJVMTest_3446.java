import java.io.*;
import java.security.cert.*;

public class MyJVMTest_3446 {

    String getName() {
        return "CTOR Test (by-keyID)";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3446().getName());
    }
}
