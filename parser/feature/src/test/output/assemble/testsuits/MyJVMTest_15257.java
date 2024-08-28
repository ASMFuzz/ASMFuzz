import java.io.*;
import java.net.*;

public class MyJVMTest_15257 {

    void reset() {
        System.out.println("install deploy cache handler");
        ResponseCache.setDefault(new TestCache());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15257().reset();
    }
}
