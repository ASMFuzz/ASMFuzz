public class MyJVMTest_3812 {

    static boolean friendly = true;

    void checkPropertiesAccess() {
        if (!friendly) {
            throw new SecurityException("No way");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3812().checkPropertiesAccess();
    }
}
