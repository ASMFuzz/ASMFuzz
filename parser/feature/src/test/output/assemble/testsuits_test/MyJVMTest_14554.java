public class MyJVMTest_14554 {

    static int[] array = { 7, 8, 0, 1482324017, 1738274935, 0, 2, 2093596691, 5, 0 };

    static int k = 1811785082;

    static int j = 4;

    int test2_helper(int[] array, int k, int j) {
        if (k == 2) {
            array[0] = j;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14554().test2_helper(array, k, j);
    }
}
