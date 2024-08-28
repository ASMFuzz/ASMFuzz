public class MyJVMTest_13532 {

    static int div = 4;

    static int[] array = { 0, 0, 1, 2, 1, 0, 0, 0, 7, 1 };

    int test2(int div, int[] array) {
        int res = 0;
        for (int i = 0; i < 256; i++) {
            int j = 0;
            do {
                array[i] = i;
                try {
                    res = 1 / div;
                } catch (ArithmeticException ex) {
                }
            } while (++j < 9);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13532().test2(div, array));
    }
}
