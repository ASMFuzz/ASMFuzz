public class MyJVMTest_6683 {

    static boolean b = false;

    static double d = Double.MIN_VALUE;

    static int[] iArr = {715336625,-113775635,9,0,0,529931880,7,-442732841,6,6};

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
        new MyJVMTest_6683().test();
    }
}
