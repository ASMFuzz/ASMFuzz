public class MyJVMTest_8459 {

    static int[] src = { 0, -2130173656, 0, 0, 0, 0, 0, 0, 1716709373, 7 };

    int[] verify(int[] src) {
        for (int i = 0; i < src.length; i++) {
            int value = (i - 1 + src.length) % src.length;
            if (src[i] != value) {
                System.out.println("Error: src[" + i + "] should be " + value + " instead of " + src[i]);
                System.exit(97);
            }
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8459().verify(src);
    }
}
