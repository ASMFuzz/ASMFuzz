public class MyJVMTest_12549 {

    static boolean b = false;

    boolean checkTrue(boolean b) {
        if (!b)
            throw new RuntimeException("test failed");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12549().checkTrue(b);
    }
}
