public class MyJVMTest_15827 {

    static Object[] listeners = { -1721873901, -1239108281, 1876883588, 0, 0, 7, 1561943196, 3, 0, 0 };

    int test(Object[] listeners) {
        int length = listeners.length;
        if (length > 10) {
            throw new RuntimeException("The count of listeners is: " + length);
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15827().test(listeners);
    }
}
