public class MyJVMTest_18115 {

    static int[] array_src = { 1203694504, 4, 0, 0, 627517205, 0, 0, 3, 8, 1987495646 };

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
        System.out.println(new MyJVMTest_18115().test(array_src));
    }
}
