public class MyJVMTest_14234 {

    static long div = 7416233534055379662L;

    static int[] array = { 2124247849, -117060993, 1535589146, 2, 1, 0, -53074915, 7, 1449351932, 4 };

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
        System.out.println(new MyJVMTest_14234().test3(div, array));
    }
}
