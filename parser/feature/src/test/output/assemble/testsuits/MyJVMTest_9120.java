import java.io.*;

public class MyJVMTest_9120 {

    static String errStr = "K(m\\o}*uTq";

    String failTest(String errStr) {
        System.out.println(errStr);
        throw new Error(errStr);
        return errStr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9120().failTest(errStr);
    }
}
