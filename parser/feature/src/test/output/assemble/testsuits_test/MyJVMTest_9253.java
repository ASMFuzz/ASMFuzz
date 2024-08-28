import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_9253 {

    static int value = -41975128;

    static int hashValue = 1506012581;

    static boolean hashValueInitialized = false;

    int setHashValue(int value) {
        hashValue = value;
        hashValueInitialized = true;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9253().setHashValue(value);
    }
}
