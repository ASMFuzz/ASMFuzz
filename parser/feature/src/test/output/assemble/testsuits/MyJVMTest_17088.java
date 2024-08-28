public class MyJVMTest_17088 {

    void testul() {
        long total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += ((v >= 1 && v < 3) ? 1L : 2L);
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17088().testul();
    }
}
