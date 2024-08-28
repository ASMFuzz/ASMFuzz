public class MyJVMTest_7364 {

    static String text = "l;r?})za-a";

    static int i = 2;

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
        System.out.println(new MyJVMTest_7364().verify(text, i, elem, val));
    }
}
