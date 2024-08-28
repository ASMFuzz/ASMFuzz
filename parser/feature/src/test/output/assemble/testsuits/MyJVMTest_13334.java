public class MyJVMTest_13334 {

    static int npeCount = 0;

    void test2() {
        Object[][] a;
        try {
            Object o = (a = null)[0][0];
        } catch (NullPointerException npe) {
            npeCount++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13334().test2();
    }
}
