public class MyJVMTest_9154 {

    static boolean b = false;

    boolean assertTrue(boolean b) {
        if (!b) {
            throw new RuntimeException("expected true, but get false.");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9154().assertTrue(b);
    }
}
