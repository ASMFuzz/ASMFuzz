public class MyJVMTest_9010 {

    static boolean b = false;

    static double d = 0d;

    static int[] iArr = {0,2027893909,2,1232201284,-616911661,0,453061324,-653826470,5,8};

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
        new MyJVMTest_9010().test();
    }
}
