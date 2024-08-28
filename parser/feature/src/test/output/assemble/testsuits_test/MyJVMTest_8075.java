public class MyJVMTest_8075 {

    static int[] src = { 0, 0, 7, 0, 3, 0, 3, 1602862699, 0, 5 };

    int[] init(int[] src) {
        for (int i = 0; i < src.length; i++) {
            src[i] = i;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8075().init(src);
    }
}
