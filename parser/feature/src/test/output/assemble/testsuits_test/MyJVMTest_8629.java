import java.nio.charset.*;

public class MyJVMTest_8629 {

    static String csn = "D|Jr,gUV\\1";

    static boolean testRegistered = false;

    String check(String csn, boolean testRegistered) throws Exception {
        if (!Charset.forName(csn).isRegistered() && testRegistered)
            throw new Exception("Not registered: " + csn);
        else if (Charset.forName(csn).isRegistered() && !testRegistered)
            throw new Exception("Registered: " + csn + "should be unregistered");
        return csn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8629().check(csn, testRegistered);
    }
}
