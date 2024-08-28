public class MyJVMTest_4309 {

    static int iFld = 0;

    static int x = 42;

    static int y = 31;

    static int z = 22;

    static int[] iArr = new int[10];

    int test4() {
        iFld = 13;
        if (z < 34) {
            z = 34;
        }
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
                        if (iFld == -7) {
                            return iFld;
                        }
                        z = iArr[5];
                        iFld >>= 1;
                }
            }
            iArr[5] = 34;
        }
        return iFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4309().test4());
    }
}
