public class MyJVMTest_380 {

    static int[] array = { 1877100650, 0, 7, 0, 0, 0, 7, 8, 0, 0 };

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
        new MyJVMTest_380().test3(array);
    }
}
