public class MyJVMTest_13636 {

    static long div = -9223372036854775808L;

    static int[] array = { 1862959045, -2027445778, 0, 7, 0, 0, 0, 0, 0, 1579951313 };

    long test4(long div, int[] array) {
        long res = 0;
        for (int i = 0; i < 256; i++) {
            int j = 0;
            do {
                array[i] = i;
                try {
                    res = 1L / div;
                } catch (ArithmeticException ex) {
                }
            } while (++j < 9);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13636().test4(div, array));
    }
}
