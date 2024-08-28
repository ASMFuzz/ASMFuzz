public class MyJVMTest_8000 {

    static boolean b = false;

    boolean assertTrue(boolean b) {
        if (!b)
            throw new AssertionError();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8000().assertTrue(b);
    }
}
