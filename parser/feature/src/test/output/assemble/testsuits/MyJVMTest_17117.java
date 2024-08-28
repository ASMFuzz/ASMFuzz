public class MyJVMTest_17117 {

    void testdl() {
        long total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += (v > 1.0) ? 1L : 2L;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17117().testdl();
    }
}
