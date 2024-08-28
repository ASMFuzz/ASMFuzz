public class MyJVMTest_14884 {

    static int ignored = 0;

    static long[] array = new long[10];

    int test_stores_1(int ignored) {
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        return ignored;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14884().test_stores_1(ignored);
    }
}
