import java.security.Policy;

public class MyJVMTest_10894 {

    static String filePath = "DpbzvI0KI/";

    static boolean hasSM = true;

    static Policy origPolicy = null;

    static String testName = "Yz9%\"SS},9";

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
        new MyJVMTest_10894().setUp();
    }
}
