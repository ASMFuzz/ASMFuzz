public class MyJVMTest_15589 {

    static double e = Double.MAX_VALUE;

    static int i = -1778996807;

    void test() {
        final Object a = new Object();
        final Object b = new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (a) {
                    do {
                        i |= 1;
                    } while (i != 3);
                    synchronized (b) {
                        e = 1;
                    }
                }
            }
        }).start();
        synchronized (b) {
            do {
                i |= 2;
            } while (i != 3);
            synchronized (a) {
                e = 2;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15589().run();
    }
}
