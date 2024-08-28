public class MyJVMTest_17566 {

    static boolean b = false;

    boolean assertTrue(boolean b) {
        if (!b)
            throw new AssertionError();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17566().assertTrue(b);
    }
}
