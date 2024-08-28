public class MyJVMTest_9524 {

    static boolean b = false;

    boolean checkFalse(boolean b) {
        if (b)
            throw new RuntimeException("test failed");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9524().checkFalse(b);
    }
}
