public class MyJVMTest_7075 {

    static int iFldStatic = 10;

    static int iFld = 11;

    int test() {
        int a = 1;
        int b = 2;
        int c = 3;
        int v = 4;
        int w = 5;
        int x = 6;
        int y = 7;
        int z = 8;
        int[] iArr = new int[400];
        double d = 1.5;
        int k = 0;
        for (a = 9; a < 283; a += 2) {
            for (int i = 8; i < 183; i++) {
            }
        }
        for (int i = 12; i < 283; i++) {
            iFldStatic += i;
            for (int j = 1; 93 > j; j += 2) {
                x += (j - z);
                c -= iFld;
                k = 3;
                while ((k -= 2) > 0) {
                }
                switch((i % 8) + 52) {
                    case 52:
                        iArr[8] = 5;
                        for (int i20 = 1; i20 < 3; ++i20) {
                            x *= (int) d;
                            w += 5;
                        }
                        break;
                    case 53:
                    case 55:
                        v *= iFldStatic;
                        break;
                    case 56:
                    case 57:
                        try {
                            iArr[5] = a;
                            v = (a / b);
                        } catch (ArithmeticException a_e) {
                        }
                        break;
                    default:
                        iFldStatic += iFldStatic;
                }
            }
        }
        return y + k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7075().test());
    }
}
