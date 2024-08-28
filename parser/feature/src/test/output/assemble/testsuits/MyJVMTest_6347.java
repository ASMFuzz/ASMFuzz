public class MyJVMTest_6347 {

    static Object[] listeners = { 2, 9, -115597413, 0, 6, 0, 0, 5, 0, 3 };

    int test(Object[] listeners) {
        int length = listeners.length;
        if (length > 10) {
            throw new RuntimeException("The count of listeners is: " + length);
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6347().test(listeners);
    }
}
