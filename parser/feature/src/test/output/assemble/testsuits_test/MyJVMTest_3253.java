public class MyJVMTest_3253 {

    static int N = 64;

    static byte byFld = 127;

    static int[] iArr = new int[N + 1];

    void test() {
        for (int i = 0; i < N; ++i) {
            iArr[i + 1] = i;
            iArr[i] -= 15;
            byFld += 35;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3253().test();
    }
}
