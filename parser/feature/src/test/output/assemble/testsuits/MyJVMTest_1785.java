public class MyJVMTest_1785 {

    static int expected = 7;

    static String val = "`EZ@[tD Fg";

    int check(int expected, String val) {
        int n = Integer.parseInt(val);
        if (n != expected)
            throw new RuntimeException("Integer.parseInt failed. String:" + val + " Result:" + n);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1785().check(expected, val);
    }
}
