public class MyJVMTest_14702 {

    static String text = "fW?<t.RSxQ";

    static int i = -1073333374;

    static boolean elem = false;

    static boolean val = true;

    int verify(String text, int i, boolean elem, boolean val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14702().verify(text, i, elem, val));
    }
}
