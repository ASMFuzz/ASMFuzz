public class MyJVMTest_17644 {

    static int[] src = { 9, 0, 0, -1300575661, 463777896, 0, 7, 0, 3, 3 };

    int[] init(int[] src) {
        for (int i = 0; i < src.length; i++) {
            src[i] = i;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17644().init(src);
    }
}
