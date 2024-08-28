public class MyJVMTest_1974 {

    void test1() {
        int i4, i5 = 99, i6, i9 = 89;
        for (i4 = 12; i4 < 365; i4++) {
            for (i6 = 5; i6 > 1; i6--) {
                switch((i6 * 5) + 11) {
                    case 13:
                    case 19:
                    case 26:
                    case 31:
                    case 35:
                    case 41:
                    case 43:
                    case 61:
                    case 71:
                    case 83:
                    case 314:
                        i9 = i5;
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1974().test1();
    }
}
