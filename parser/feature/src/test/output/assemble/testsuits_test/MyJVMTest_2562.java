public class MyJVMTest_2562 {

    static int div = 0;

    static int[] array = { 0, 1476415988, -830781169, 2, 5, 0, 0, 2, 0, 8 };

    int test1(int div, int[] array) {
        int res = 0;
        for (int i = 0; i < 256; i++) {
            int j = 0;
            do {
                array[i] = i;
                try {
                    res = 1 % div;
                } catch (ArithmeticException ex) {
                }
            } while (++j < 9);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2562().test1(div, array));
    }
}
