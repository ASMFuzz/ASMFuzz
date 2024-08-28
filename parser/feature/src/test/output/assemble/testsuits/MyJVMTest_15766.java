import java.io.*;
import java.net.*;

public class MyJVMTest_15766 {

    static int count = 0;

    void resetCount() {
        count = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15766().resetCount();
    }
}
