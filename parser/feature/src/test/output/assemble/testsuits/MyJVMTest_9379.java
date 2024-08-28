public class MyJVMTest_9379 {

    static long lFld = 0;

    static double dFld = 0;

    void test2() {
        int[] iArr = new int[10];
        for (int i = 6; i < 10; i++) {
            for (int j = 8; j > i; j--) {
                int k = 1;
                do {
                    iArr[j] = 0;
                    switch(k) {
                        case 1:
                            lFld = 0;
                            break;
                        case 10:
                            dFld = 0;
                            break;
                    }
                } while (++k < 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9379().test2();
    }
}
