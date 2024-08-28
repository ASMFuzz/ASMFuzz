import java.io.*;
import java.security.*;

public class MyJVMTest_6232 {

    Object run() throws FileNotFoundException {
        return new FileInputStream("someFile");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6232().run());
    }
}
