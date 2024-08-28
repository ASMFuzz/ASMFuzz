import java.io.*;

public class MyJVMTest_6919 {

    static String errStr = "Y\"5=#o1Y%u";

    String failTest(String errStr) {
        System.out.println(errStr);
        throw new Error(errStr);
        return errStr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6919().failTest(errStr);
    }
}
