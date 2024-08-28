import java.io.*;
import java.awt.*;

public class MyJVMTest_7595 {

    int read() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7595().read());
    }
}
