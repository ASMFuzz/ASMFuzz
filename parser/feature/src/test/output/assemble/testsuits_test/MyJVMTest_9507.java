public class MyJVMTest_9507 {

    static int stop = 8;

    static int[] array = { 1295771215, 8, 2, -1582161058, 0, -1344602276, -1963657491, 5, 0, 6 };

    static int val = 0;

    float test(int stop, int[] array, int val) {
        if (array == null) {
        }
        int j;
        for (j = 0; j < 10; j++) {
        }
        int i;
        int v = 0;
        float f = 1;
        for (i = 0; i < 10000; i++) {
            if ((j - 10) * i + val == 42) {
                f *= 2;
            } else {
                f *= 3;
            }
            v = (j - 10) * array[i];
            if (i % 10001 != i) {
                return v;
            }
        }
        return v + array[i - 1] + f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9507().test(stop, array, val));
    }
}
