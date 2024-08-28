public class MyJVMTest_8524 {

    static int[] array_src = { 0, 1123785548, 2, 1, 4, 7, -1091661308, 6, 5, 4 };

    boolean test(int[] array_src) {
        int[] array_dst = new int[10];
        System.arraycopy(array_src, 0, array_dst, 0, 10);
        for (int i = 0; i < 100; i++) {
            array_src[i] = i;
        }
        if (array_dst[0] == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8524().test(array_src));
    }
}
