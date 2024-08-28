public class MyJVMTest_8772 {

    static String text = ":,3Q0t;\"<}";

    static int i = 0;

    static int elem = 626192395;

    static int val = 0;

    int verify(String text, int i, int elem, int val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8772().verify(text, i, elem, val));
    }
}
