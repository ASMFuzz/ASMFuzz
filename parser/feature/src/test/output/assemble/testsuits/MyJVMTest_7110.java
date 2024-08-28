public class MyJVMTest_7110 {

    static int npeCount = 0;

    void test3() {
        Object[][][] a;
        try {
            Object o = (a = null)[0][0][0];
        } catch (NullPointerException npe) {
            npeCount++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7110().test3();
    }
}
