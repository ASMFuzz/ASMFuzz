public class MyJVMTest_14683 {

    static int[] src = { 0, 0, 4, 682566357, 0, -430380976, -1944818511, 4, 6, -1174225654 };

    static boolean flag1 = false;

    static boolean flag2 = false;

    static int[] escaped = {9,0,8,1,5,1,451149221,0,8,1133366056};

    int[] test(int[] src, boolean flag1, boolean flag2) {
        int[] array = new int[10];
        if (flag1) {
            System.arraycopy(src, 0, array, 0, src.length);
        } else {
        }
        if (flag2) {
            escaped = array;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14683().test(src, flag1, flag2);
    }
}
