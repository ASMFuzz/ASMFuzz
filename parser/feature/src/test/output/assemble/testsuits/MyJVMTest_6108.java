public class MyJVMTest_6108 {

    static boolean cond = true;

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
        new MyJVMTest_6108().moo(cond);
    }
}
