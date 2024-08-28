public class MyJVMTest_4862 {

    void Attack() {
        if (Attack.class.getClassLoader() != null)
            throw new RuntimeException("Attack class not on boot class path");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4862().Attack();
    }
}
