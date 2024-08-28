public class MyJVMTest_12209 {

    static int iFld = 3;

    static int x = 42;

    static int y = 31;

    static int[] iArr = new int[10];

    int test2() {
        iFld = 13;
        int k = 0;
        for (int i = 0; i < 8; i++) {
            int j = 10;
            while (--j > 0) {
                iFld += -7;
                x = y + iFld;
                y = iArr[5];
                k = 6;
                iArr[5] = 5;
                iArr[6] += 23;
                iArr[7] = iArr[8] + iArr[6];
                iArr[j] = 34;
                switch((i * 5) + 102) {
                    case 120:
                        break;
                    case 103:
                        break;
                    case 116:
                        break;
                    default:
                        iFld >>= 1;
                }
            }
        }
        return iFld + k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12209().test2());
    }
}
