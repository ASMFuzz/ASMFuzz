public class MyJVMTest_13900 {

    static int[] iArr = new int[10];

    void test() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 10; j++) {
                iArr[i] = j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13900().test();
    }
}
