public class MyJVMTest_13760 {

    void checkPrivileges() {
        boolean haveSecurityManager = (System.getSecurityManager() != null);
        try {
            System.getProperty("java.home");
            if (haveSecurityManager) {
                throw new Error("exception exception not thrown");
            }
        } catch (SecurityException e) {
            if (!haveSecurityManager) {
                throw new Error("unexpected exception: " + e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13760().checkPrivileges();
    }
}
