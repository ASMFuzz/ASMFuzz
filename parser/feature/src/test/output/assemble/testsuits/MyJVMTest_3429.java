public class MyJVMTest_3429 {

    void test() {
        for (int j = 0; j < 5; ++j) {
            long x = 0;
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; ++i) {
                x += i;
            }
            System.out.println("sum: " + x);
            if (x != -4294967295l) {
                System.out.println("FAILED");
                System.exit(97);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3429().test();
    }
}
