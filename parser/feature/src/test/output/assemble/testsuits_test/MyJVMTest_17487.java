public class MyJVMTest_17487 {

    static boolean flag = false;

    boolean test(boolean flag) {
        if (flag) {
            while (true) {
                for (int i = 1; i < 100; i *= 2) {
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17487().test(flag);
    }
}
