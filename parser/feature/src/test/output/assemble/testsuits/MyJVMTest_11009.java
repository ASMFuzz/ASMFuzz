public class MyJVMTest_11009 {

    static int expected = 8;

    static String val = "R\\b~a45 Pa";

    int check(int expected, String val) {
        int n = Integer.parseInt(val);
        if (n != expected)
            throw new RuntimeException("Integer.parseInt failed. String:" + val + " Result:" + n);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11009().check(expected, val);
    }
}
