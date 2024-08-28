public class MyJVMTest_1833 {

    static boolean b = false;

    static A a = null;

    boolean assertTrue(boolean b) {
        if (!b)
            throw new AssertionError();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1833().assertTrue(b);
    }
}
