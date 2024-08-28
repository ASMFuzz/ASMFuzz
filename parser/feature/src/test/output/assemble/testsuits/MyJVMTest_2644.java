public class MyJVMTest_2644 {

    static boolean cond = true;

    static Collection<Integer> c = null;

    static int a = 1635742058, b = 5, c = 0, d = -887308682, e = 6;

    boolean testForEachLoop(boolean cond, java.util.Collection<Integer> c) {
        final int bug;
        for (Integer i : c) {
            if (cond) {
                final int item = 0;
            }
        }
        bug = 0;
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2644().testForEachLoop(cond, c);
    }
}
