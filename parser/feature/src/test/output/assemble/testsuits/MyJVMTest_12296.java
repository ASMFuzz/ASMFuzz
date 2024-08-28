public class MyJVMTest_12296 {

    static int[] src = { 3, 5, 0, 5, 8, 1, -1412001041, 683534821, 1941772578, 3 };

    int[] shift(int[] src) {
        for (int i = src.length - 1; i > 0; i--) {
            int tmp = src[i];
            src[i] = src[i - 1];
            src[i - 1] = tmp;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12296().shift(src);
    }
}
