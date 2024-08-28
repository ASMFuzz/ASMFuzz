import java.util.*;

public class MyJVMTest_7521 {

    static String diagnostic = "*?SGKB,fU(";

    static boolean failure = false;

    String fail(String diagnostic) {
        new Error(diagnostic).printStackTrace();
        failure = true;
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7521().fail(diagnostic);
    }
}
