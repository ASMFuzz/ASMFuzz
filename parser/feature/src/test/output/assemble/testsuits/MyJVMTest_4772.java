public class MyJVMTest_4772 {

    static long l = 0;

    static boolean[] arr = new boolean[20];

    long vMeth(long l) {
        for (int a = 2; a < 155; a++) {
            for (int b = 1; b < 10; ++b) {
                for (int c = 1; c < 2; c++) {
                    l += 3 * l;
                    arr[b - 1] = false;
                    switch(a) {
                        case 14:
                        case 17:
                            l -= b;
                            break;
                    }
                }
            }
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4772().vMeth(l);
    }
}
