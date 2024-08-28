public class MyJVMTest_7555 {

    static String text = "go'aeuT/o<";

    static int i = 5;

    static float elem = Float.POSITIVE_INFINITY;

    static float val = Float.POSITIVE_INFINITY;

    int verify(String text, int i, float elem, float val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7555().verify(text, i, elem, val));
    }
}
