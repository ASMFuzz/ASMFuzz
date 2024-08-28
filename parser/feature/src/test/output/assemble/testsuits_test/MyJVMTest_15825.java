import java.io.*;
import java.security.cert.*;

public class MyJVMTest_15825 {

    String getName() {
        return "Get Encoded Value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15825().getName());
    }
}
