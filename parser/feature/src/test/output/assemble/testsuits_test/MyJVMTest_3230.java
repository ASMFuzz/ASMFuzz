public class MyJVMTest_3230 {

    static boolean b = false;

    boolean checkTrue(boolean b) {
        if (!b)
            throw new RuntimeException("test failed");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3230().checkTrue(b);
    }
}
