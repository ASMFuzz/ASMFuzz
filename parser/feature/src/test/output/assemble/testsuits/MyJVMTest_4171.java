public class MyJVMTest_4171 {

    static int div = 0;

    static int[] array = { 2, 7, 1, 7, 7, 1252678738, 4, 1549493392, -67560880, 262348839 };

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
        System.out.println(new MyJVMTest_4171().test2(div, array));
    }
}
