public class MyJVMTest_14262 {

    void Attack() {
        if (Attack.class.getClassLoader() != null)
            throw new RuntimeException("Attack class not on boot class path");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14262().Attack();
    }
}
