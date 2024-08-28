public class MyJVMTest_17097 {

    static String text = "o :zF2k^tO";

    static int i = 4;

    static float elem = 0.5910578f;

    static float val = Float.NEGATIVE_INFINITY;

    int verify(String text, int i, float elem, float val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17097().verify(text, i, elem, val));
    }
}
