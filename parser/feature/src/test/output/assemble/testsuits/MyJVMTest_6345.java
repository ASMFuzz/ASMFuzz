import java.io.*;
import java.security.cert.*;

public class MyJVMTest_6345 {

    String getName() {
        return "Get Encoded Value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6345().getName());
    }
}
