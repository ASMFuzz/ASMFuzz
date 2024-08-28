public class MyJVMTest_10388 {

    int test() {
        byte by = -37;
        int result = 1;
        int[] iArr = new int[6];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
        for (int i = 16; i < 308; i++) {
            result *= i;
            if ((result--) <= (++by)) {
                continue;
            }
            for (int j = 3; j < 86; j++) {
                for (int k = 1; k < 2; k++) {
                    result >>= 25;
                }
                for (int k = 1; k < 2; k += 3) {
                    try {
                        iArr[k] = (16986 / result);
                    } catch (ArithmeticException a_e) {
                    }
                    result = k;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10388().test());
    }
}
