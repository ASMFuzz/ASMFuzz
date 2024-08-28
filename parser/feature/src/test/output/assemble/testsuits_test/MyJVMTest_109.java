import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_109 {

    static int value = 0;

    static int hashValue = 0;

    static boolean hashValueInitialized = false;

    int setHashValue(int value) {
        hashValue = value;
        hashValueInitialized = true;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_109().setHashValue(value);
    }
}
