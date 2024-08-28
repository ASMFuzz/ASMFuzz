import java.io.*;
import java.security.cert.*;

public class MyJVMTest_3865 {

    String getName() {
        return "Simple Equality Test";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3865().getName());
    }
}
