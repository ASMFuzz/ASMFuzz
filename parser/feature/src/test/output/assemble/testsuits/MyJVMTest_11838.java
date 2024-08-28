public class MyJVMTest_11838 {

    static int div = 0;

    static int[] array = { -1263790851, 0, 2, 5, 4, 135803179, 6, 9, 0, -1683866917 };

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
        System.out.println(new MyJVMTest_11838().test1(div, array));
    }
}
