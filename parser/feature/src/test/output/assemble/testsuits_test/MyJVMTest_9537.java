public class MyJVMTest_9537 {

    static int[] array = { 1, -1789327403, 7, -735381593, -682410843, 1818627451, 328793564, 0, 7, 0 };

    static long lFld = 0;

    static double dFld = 0;

    int[] test3(int[] array) {
        int[] iArr = new int[8];
        for (int i = 0; i < array.length; i++) {
            for (int j = 5; j < i; j++) {
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
        return iArr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9537().test3(array);
    }
}
