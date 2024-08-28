public class MyJVMTest_15572 {

    static boolean cond = false;

    boolean moo(boolean cond) {
        Integer i = 100;
        do {
            if (cond) {
                return;
            } else {
                return;
            }
        } while (i++ < 10);
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15572().moo(cond);
    }
}
