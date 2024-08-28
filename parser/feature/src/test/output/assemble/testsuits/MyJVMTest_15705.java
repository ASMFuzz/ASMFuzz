import java.io.*;
import java.security.*;

public class MyJVMTest_15705 {

    Object run() throws FileNotFoundException {
        return new FileInputStream("someFile");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15705().run());
    }
}
