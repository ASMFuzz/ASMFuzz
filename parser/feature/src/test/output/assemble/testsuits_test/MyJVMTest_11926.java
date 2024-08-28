public class MyJVMTest_11926 {

    static boolean cond = false;

    static Collection<Integer> c = null;

    static int a = 9, b = 7, c = 0, d = 1641031055, e = 0;

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
        new MyJVMTest_11926().testForEachLoop(cond, c);
    }
}
