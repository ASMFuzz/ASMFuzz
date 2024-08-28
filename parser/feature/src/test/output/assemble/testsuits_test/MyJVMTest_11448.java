public class MyJVMTest_11448 {

    static String text = "19QR!g)9$\\";

    static int i = 0;

    static char elem = '0';

    static char val = '0';

    int verify(String text, int i, char elem, char val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11448().verify(text, i, elem, val));
    }
}
