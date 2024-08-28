public class MyJVMTest_8793 {

    static boolean b = false;

    boolean assertTrue(boolean b) {
        if (!b) {
            throw new RuntimeException("expected true, but get false.");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8793().assertTrue(b);
    }
}
