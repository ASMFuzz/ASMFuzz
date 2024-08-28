public class MyJVMTest_9596 {

    static int[] array = { 0, 7, 9, 0, 0, 0, 0, 0, 0, 0 };

    static boolean store = false;

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
        new MyJVMTest_9596().test4(array, store);
    }
}
