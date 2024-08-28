public class MyJVMTest_1552 {

    int[] m1(int[] a2) {
        int[] a1 = new int[10];
        System.arraycopy(a1, 0, a2, 0, 10);
        return a1;
    }

    void test1() {
        int[] a2 = new int[10];
        int[] a3 = new int[5];
        for (int i = 0; i < 20000; i++) {
            m1(a2);
        }
        for (int i = 0; i < 10; i++) {
            try {
                m1(a3);
            } catch (IndexOutOfBoundsException ioobe) {
            }
        }
        for (int i = 0; i < 20000; i++) {
            m1(a2);
        }
        try {
            m1(null);
        } catch (NullPointerException npe) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1552().test1();
    }
}
