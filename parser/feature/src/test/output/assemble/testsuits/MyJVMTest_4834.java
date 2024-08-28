public class MyJVMTest_4834 {

    static long div = -9223372036854775808L;

    static int[] array = { 2, 1, 1687660821, 9, 7, 5, 8, 2, 5, 3 };

    long test3(long div, int[] array) {
        long res = 0;
        for (int i = 0; i < 256; i++) {
            int j = 0;
            do {
                array[i] = i;
                try {
                    res = 1L % div;
                } catch (ArithmeticException ex) {
                }
            } while (++j < 9);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4834().test3(div, array));
    }
}
