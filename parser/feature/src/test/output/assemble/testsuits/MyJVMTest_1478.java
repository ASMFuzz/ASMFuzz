public class MyJVMTest_1478 {

    static boolean cond = true;

    boolean test(boolean cond) {
        try {
            if (cond) {
                throw new Exception1();
            } else {
                throw new Exception2();
            }
        } catch (Exception1 | Exception2 x) {
            if (x instanceof Exception1) {
            }
        }
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1478().test(cond);
    }
}
