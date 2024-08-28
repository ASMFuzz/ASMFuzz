public class MyJVMTest_11654 {

    void testfl() {
        long total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += (v > 1.0f) ? 1L : 2L;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11654().testfl();
    }
}
