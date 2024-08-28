public class MyJVMTest_17702 {

    static boolean toggleButtonActionPerformed = false;

    void checkToggleButtonActionPerformed() {
        if (toggleButtonActionPerformed) {
            throw new RuntimeException("Toggle Button Action should not be" + "performed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17702().checkToggleButtonActionPerformed();
    }
}
