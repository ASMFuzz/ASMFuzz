public class MyJVMTest_11059 {

    static boolean b = true;

    static A a = null;

    boolean assertTrue(boolean b) {
        if (!b)
            throw new AssertionError();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11059().assertTrue(b);
    }
}
