public class MyJVMTest_17811 {

    static Object[] listeners = { -73080032, 7, 2, 0, 3, 9, 3, 7, 0, 0 };

    int test(Object[] listeners) {
        int length = listeners.length;
        if (length > 20) {
            throw new RuntimeException("The count of listeners is: " + length);
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17811().test(listeners);
    }
}
