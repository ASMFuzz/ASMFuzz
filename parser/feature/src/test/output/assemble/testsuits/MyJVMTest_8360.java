import java.io.*;
import java.security.cert.*;

public class MyJVMTest_8360 {

    String getName() {
        return "Get Underlying Responder Name";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8360().getName());
    }
}
