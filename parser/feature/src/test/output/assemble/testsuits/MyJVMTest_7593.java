public class MyJVMTest_7593 {

    void testl() {
        long total = 0;
        for (int i = 0; i < 10000; i++) {
            total += (i % 4 != 0) ? 1L : 2L;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7593().testl();
    }
}
