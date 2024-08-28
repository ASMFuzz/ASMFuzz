import java.io.*;
import java.security.cert.*;

public class MyJVMTest_17941 {

    String getName() {
        return "Get Underlying Responder Name";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17941().getName());
    }
}
