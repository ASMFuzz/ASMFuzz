public class MyJVMTest_2762 {

    static boolean flag = true;

    static int[] array2 = { 0, 1054093509, 1621524314, 0, 94298383, 9, 1044596304, -1917627925, -1065273893, 3 };

    static boolean flag2 = true;

    static int start = 9;

    static int stop = 3;

    int test(boolean flag, int[] array2, boolean flag2, int start, int stop) {
        if (array2 == null) {
        }
        int[] array;
        if (flag) {
            array = new int[1];
        } else {
            array = new int[2];
        }
        int len = array.length;
        int v = 1;
        for (int j = start; j < stop; j++) {
            for (int i = 0; i < len; i++) {
                if (i > 0) {
                    if (flag2) {
                        break;
                    }
                    v *= array2[i + j];
                }
            }
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2762().test(flag, array2, flag2, start, stop));
    }
}
