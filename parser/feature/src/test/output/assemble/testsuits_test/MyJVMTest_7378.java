public class MyJVMTest_7378 {

    static int x = 1;

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
        new MyJVMTest_7378().f(x);
    }
}
