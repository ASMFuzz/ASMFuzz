public class MyJVMTest_9429 {

    static boolean flag1 = true;

    static boolean flag2 = true;

    void not_inlined(int[] array) {
    }

    int test1(boolean flag1, boolean flag2) {
        int res = 1;
        int[] array = new int[10];
        not_inlined(array);
        int i;
        for (i = 0; i < 2000; i++) {
            res *= i;
        }
        if (flag1) {
            if (flag2) {
                res++;
            }
        }
        if (i >= 2000) {
            res *= array[0];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9429().test1(flag1, flag2));
    }
}
