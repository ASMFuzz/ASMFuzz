public class MyJVMTest_8993 {

    static boolean flag = false;

    static int[] array2 = { 5, 0, 5, 0, 0, 8, 5, 9, -730689044, 1821067264 };

    static boolean flag2 = false;

    static int start = 8;

    static int stop = 6;

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
        System.out.println(new MyJVMTest_8993().test(flag, array2, flag2, start, stop));
    }
}
