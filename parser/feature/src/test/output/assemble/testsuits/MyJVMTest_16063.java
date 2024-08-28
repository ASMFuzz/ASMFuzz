public class MyJVMTest_16063 {

    static int iFld = 8;

    static int[] iArr = new int[10];

    int test7() {
        iFld = 13;
        for (int i = 0; i < 8; i++) {
            int j = 10;
            while (--j > 0) {
                iFld += -7;
                iArr[5] = 8;
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
        System.out.println(new MyJVMTest_16063().test7());
    }
}
