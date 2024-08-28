public class MyJVMTest_9283 {

    static boolean toggleButtonActionPerformed = true;

    void checkCheckboxActionPerformed() {
        if (toggleButtonActionPerformed) {
            throw new RuntimeException("Checkbox Action should not be" + "performed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9283().checkCheckboxActionPerformed();
    }
}
