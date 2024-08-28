public class MyJVMTest_17588 {

    static int iFld = 0;

    int test() {
        iFld = 13;
        for (int i = 0; i < 8; i++) {
            int j = 10;
            while (--j > 0) {
                iFld += -7;
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
        return iFld;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17588().test());
    }
}
