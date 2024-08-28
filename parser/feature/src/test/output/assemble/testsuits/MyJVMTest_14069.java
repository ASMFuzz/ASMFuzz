public class MyJVMTest_14069 {

    static int iFld = 4;

    static int x = 42;

    static int y = 31;

    static int[] iArr = new int[10];

    int test5() {
        iFld = 13;
        for (int i = 0; i < 8; i++) {
            int j = 10;
            while (--j > 0) {
                iFld += -7;
                iArr[5] = 8;
                x = iArr[6];
                y = x;
                for (int k = 50; k < 51; k++) {
                    x = iArr[7];
                }
                switch((i * 5) + 102) {
                    case 120:
                        return iFld;
                    case 103:
                        break;
                    case 116:
                        break;
                    default:
                        iFld >>= 1;
                }
            }
        }
        return iFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14069().test5());
    }
}
