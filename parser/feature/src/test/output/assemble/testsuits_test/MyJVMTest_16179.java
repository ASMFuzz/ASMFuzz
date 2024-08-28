public class MyJVMTest_16179 {

    static boolean b = false;

    static double d = 0d;

    static int[] iArr = {3,8,7,0,6,5,811091018,9,7,0};

    void test() {
        int e = 4, f = -51874, g = 7, h = 0;
        for (; f < 3; ++f) {
        }
        while (++g < 2) {
            if (b) {
                d = h;
            } else {
                iArr[g] = e;
            }
        }
        System.out.println(g);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16179().test();
    }
}
