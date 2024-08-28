import java.security.*;

public class MyJVMTest_17027 {

    static String msg = "Q,}7H^3^:p";

    static boolean testResult = true;

    String error(String msg) {
        testResult = false;
        System.out.println(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17027().error(msg);
    }
}
