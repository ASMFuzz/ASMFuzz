public class MyJVMTest_16894 {

    static String text = "mKVW yQ&r]";

    static int i = 0;

    static double elem = 0d;

    static double val = Double.NEGATIVE_INFINITY;

    int verify(String text, int i, double elem, double val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16894().verify(text, i, elem, val));
    }
}
