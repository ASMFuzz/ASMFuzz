public class MyJVMTest_13534 {

    static String text = "5GHG>tq)Ha";

    static int i = 3;

    static byte elem = 0;

    static byte val = 67;

    int verify(String text, int i, byte elem, byte val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13534().verify(text, i, elem, val));
    }
}
