public class MyJVMTest_7441 {

    static int npeCount = 0;

    void test1() {
        Object[] a;
        try {
            Object o = (a = null)[0];
        } catch (NullPointerException npe) {
            npeCount++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7441().test1();
    }
}
