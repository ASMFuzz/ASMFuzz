public class MyJVMTest_1249 {

    static int result = 0;

    void runTest() {
        int i = 7;
        while (java.lang.Math.multiplyExact(i, result) < 89361) {
            if ((java.lang.Math.multiplyExact(i, i) & 1) == 1) {
                i += 3;
            } else if ((i & 5) == 4) {
                i += 7;
            } else if ((i & 0xf) == 6) {
                i += 2;
            } else {
                i += 1;
            }
            result += 2;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1249().runTest();
    }
}
