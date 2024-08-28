public class MyJVMTest_12053 {

    static boolean flag = false;

    static int[] array2 = { -799852009, 0, 766653764, 0, 1251350154, 0, 8, 1, 0, -1143105393 };

    static boolean flag2 = true;

    static int start = -1454339458;

    static int stop = 8;

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
        System.out.println(new MyJVMTest_12053().test(flag, array2, flag2, start, stop));
    }
}
