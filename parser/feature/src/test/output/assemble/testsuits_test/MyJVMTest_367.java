public class MyJVMTest_367 {

    static boolean b = false;

    boolean checkFalse(boolean b) {
        if (b)
            throw new RuntimeException("test failed");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_367().checkFalse(b);
    }
}
