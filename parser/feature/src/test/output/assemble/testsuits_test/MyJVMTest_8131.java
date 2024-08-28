public class MyJVMTest_8131 {

    static boolean toggleButtonActionPerformed = false;

    void checkToggleButtonActionPerformed() {
        if (toggleButtonActionPerformed) {
            throw new RuntimeException("Toggle Button Action should not be" + "performed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8131().checkToggleButtonActionPerformed();
    }
}
