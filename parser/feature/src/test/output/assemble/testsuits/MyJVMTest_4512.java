public class MyJVMTest_4512 {

    static int[] iArr = new int[10];

    void test() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 10; j++) {
                iArr[i] = j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4512().test();
    }
}
