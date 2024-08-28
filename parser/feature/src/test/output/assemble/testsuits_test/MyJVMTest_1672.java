import java.security.Policy;

public class MyJVMTest_1672 {

    static String filePath = "NFHG9x{N91";

    static boolean hasSM = true;

    static Policy origPolicy = null;

    static String testName = "l[q!SekIZ]";

    void setUp() {
        if (System.getSecurityManager() != null) {
            hasSM = true;
            System.setSecurityManager(null);
        }
        filePath = System.getProperty("test.src");
        if (filePath == null) {
            filePath = System.getProperty("user.dir");
        }
        origPolicy = Policy.getPolicy();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1672().setUp();
    }
}
