public class MyJVMTest_4173 {

    static String text = "9y-A!u'g^x";

    static int i = 7;

    static byte elem = 0;

    static byte val = -14;

    int verify(String text, int i, byte elem, byte val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4173().verify(text, i, elem, val));
    }
}
