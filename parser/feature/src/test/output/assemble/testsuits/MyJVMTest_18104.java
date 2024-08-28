import java.awt.Button;

public class MyJVMTest_18104 {

    static String msg = "&/(Ru#-uBJ";

    static boolean testPassed = true;

    static Thread mainThread = null;

    static boolean testGeneratedInterrupt = true;

    static String message = "User has not executed the test";

    String fail(String msg) {
        testPassed = false;
        message = msg;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18104().fail(msg);
    }
}
