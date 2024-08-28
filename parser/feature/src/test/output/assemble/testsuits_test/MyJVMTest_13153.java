public class MyJVMTest_13153 {

    static boolean friendly = true;

    void checkPropertiesAccess() {
        if (!friendly) {
            throw new SecurityException("No way");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13153().checkPropertiesAccess();
    }
}
