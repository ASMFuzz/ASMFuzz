import java.io.*;

public class MyJVMTest_16429 {

    static String errStr = "-pC#V\"d)sL";

    String failTest(String errStr) {
        System.out.println(errStr);
        throw new Error(errStr);
        return errStr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16429().failTest(errStr);
    }
}
