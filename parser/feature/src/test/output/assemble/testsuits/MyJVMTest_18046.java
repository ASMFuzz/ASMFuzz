public class MyJVMTest_18046 {

    static int[] src = { 7, 126716810, -1565794265, 0, -2109151604, 101723922, 3, 8, -1017567998, 2 };

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
        new MyJVMTest_18046().verify(src);
    }
}
