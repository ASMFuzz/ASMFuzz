import javax.management.*;
import javax.management.remote.*;

public class MyJVMTest_13803 {

    static boolean done = false;

    static String errorInfo = null;

    String failed(String errorInfo) {
        this.errorInfo = errorInfo;
        done = true;
        this.notify();
        return errorInfo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13803().failed(errorInfo);
    }
}
