public class MyJVMTest_14736 {

    static String text = "-_y)K3m&Ki";

    static int i = 0;

    static int elem = 7;

    static int val = 7;

    int verify(String text, int i, int elem, int val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14736().verify(text, i, elem, val));
    }
}
