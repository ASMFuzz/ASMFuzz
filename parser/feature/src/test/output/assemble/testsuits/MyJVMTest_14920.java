public class MyJVMTest_14920 {

    static String text = "'1WO>f2\"5a";

    static int i = 9;

    static short elem = 11157;

    static short val = -32768;

    int verify(String text, int i, short elem, short val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14920().verify(text, i, elem, val));
    }
}
