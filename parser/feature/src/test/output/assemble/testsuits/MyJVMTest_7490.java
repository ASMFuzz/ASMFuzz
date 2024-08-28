import java.security.*;

public class MyJVMTest_7490 {

    static String msg = "dpa*feCDi;";

    static boolean testResult = true;

    String error(String msg) {
        testResult = false;
        System.out.println(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7490().error(msg);
    }
}
