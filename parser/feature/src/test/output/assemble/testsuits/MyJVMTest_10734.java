public class MyJVMTest_10734 {

    static int k = 8;

    double sqrtAdd(int i) {
        return 1.0 + Math.sqrt(i);
    }

    static double dFld = 3.3;

    int test(int k) {
        for (int i = 1; i < 100; i++) {
            if (k == 300) {
                return;
            }
            dFld = sqrtAdd(i);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10734().test(k);
    }
}
