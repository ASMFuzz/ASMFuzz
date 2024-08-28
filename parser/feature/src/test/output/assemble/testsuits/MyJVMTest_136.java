public class MyJVMTest_136 {

    static boolean toggleButtonActionPerformed = false;

    void checkCheckboxActionPerformed() {
        if (toggleButtonActionPerformed) {
            throw new RuntimeException("Checkbox Action should not be" + "performed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_136().checkCheckboxActionPerformed();
    }
}
