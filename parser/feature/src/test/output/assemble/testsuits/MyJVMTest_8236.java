public class MyJVMTest_8236 {

    static Object[] listeners = { 1521656165, 6, 5, 0, 6, -1298101476, 0, 0, 0, 6 };

    int test(Object[] listeners) {
        int length = listeners.length;
        if (length > 20) {
            throw new RuntimeException("The count of listeners is: " + length);
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8236().test(listeners);
    }
}
