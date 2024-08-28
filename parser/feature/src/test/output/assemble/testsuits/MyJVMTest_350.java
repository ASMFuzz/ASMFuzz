public class MyJVMTest_350 {

    static int stop = 1;

    static int[] array = { 5, 5, 8, 0, -1588941115, 932902045, -1732705967, -403049977, -797216565, 0 };

    static int val = 516760340;

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
        System.out.println(new MyJVMTest_350().test(stop, array, val));
    }
}
