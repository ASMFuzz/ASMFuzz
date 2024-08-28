public class MyJVMTest_5279 {

    static String text = "R\"Lx#+JEB^";

    static int i = -1832791146;

    static boolean elem = true;

    static boolean val = false;

    int verify(String text, int i, boolean elem, boolean val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5279().verify(text, i, elem, val));
    }
}
