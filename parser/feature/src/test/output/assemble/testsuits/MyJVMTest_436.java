public class MyJVMTest_436 {

    static int[] array = { 3, -606947902, 8, 620526728, -996732210, 0, -495852256, 0, 1466962316, -1886023241 };

    static boolean store = true;

    static long lFld = 0;

    static double dFld = 0;

    boolean test4(int[] array, boolean store) {
        int[] iArr = new int[8];
        for (int i = -8; i < 8; i++) {
            for (int j = 5; j > i; j--) {
                int k = 1;
                do {
                    if (store) {
                        iArr[j] = 0;
                    }
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
        return store;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_436().test4(array, store);
    }
}
