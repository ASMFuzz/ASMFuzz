public class MyJVMTest_1517 {

    static int k = 5;

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
        new MyJVMTest_1517().test(k);
    }
}
