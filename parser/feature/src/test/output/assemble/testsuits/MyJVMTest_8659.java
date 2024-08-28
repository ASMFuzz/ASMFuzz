public class MyJVMTest_8659 {

    static int stop = 1309523717;

    static int[] array = { -1232761514, 370256392, 0, 7, 5, 0, -44369066, 6, 0, 5 };

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
        System.out.println(new MyJVMTest_8659().test(stop, array, val));
    }
}
