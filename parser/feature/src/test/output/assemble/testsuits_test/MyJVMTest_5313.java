public class MyJVMTest_5313 {

    static String text = "?#!>socvY~";

    static int i = 6;

    static int elem = 608616012;

    static int val = 940572370;

    int verify(String text, int i, int elem, int val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5313().verify(text, i, elem, val));
    }
}
