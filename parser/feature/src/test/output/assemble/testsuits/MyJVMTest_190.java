public class MyJVMTest_190 {

    static int[] a = { 0, 9, 0, 0, 9, 597849446, 4, 0, -1968495983, 2 };

    static int start = 9;

    static int stop = -1167473943;

    static boolean flag = true;

    int test_helper(int j) {
        return j == 10 ? 10 : 1;
    }

    static int f = -1508735226;

    int test1(int[] a, int start, int stop, boolean flag) {
        int[] b = new int[2];
        System.arraycopy(a, 0, b, 0, 2);
        int v = 1;
        int j = 0;
        for (; j < 10; j++) ;
        int inc = test_helper(j);
        for (int i = start; i < stop; i += inc) {
            v *= 2;
        }
        if (flag) {
            v += b[0] + b[1];
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_190().test1(a, start, stop, flag));
    }
}
