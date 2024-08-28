public class MyJVMTest_2990 {

    static int[] src = { 5, 1, 5, 1118637797, -514929867, -2145293926, 5, -457932169, 8, 1 };

    int[] shift(int[] src) {
        for (int i = src.length - 1; i > 0; i--) {
            int tmp = src[i];
            src[i] = src[i - 1];
            src[i - 1] = tmp;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2990().shift(src);
    }
}
