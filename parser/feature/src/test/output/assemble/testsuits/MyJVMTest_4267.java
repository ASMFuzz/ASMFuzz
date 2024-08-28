public class MyJVMTest_4267 {

    static long div = 8256327498767684976L;

    static int[] array = { 0, 0, 0, 5, 0, 7, 0, 0, 8, -1789124660 };

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
        System.out.println(new MyJVMTest_4267().test4(div, array));
    }
}
