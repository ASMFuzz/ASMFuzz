import java.io.*;
import java.net.*;

public class MyJVMTest_5812 {

    void reset() {
        System.out.println("install deploy cache handler");
        ResponseCache.setDefault(new TestCache());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5812().reset();
    }
}
