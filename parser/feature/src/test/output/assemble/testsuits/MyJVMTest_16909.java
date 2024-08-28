public class MyJVMTest_16909 {

    static int x = 9;

    int f(int x) {
        final int i;
        L: {
            if (x == 0)
                break L;
            try {
                i = 3;
                break L;
            } finally {
                return;
            }
        }
        i = 2;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16909().f(x);
    }
}
