public class MyJVMTest_17710 {

    static long start_time = -2534347223320699590L;

    static long elapsed_time = 0;

    static long total_time = 0L;

    void mark() {
        elapsed_time = System.currentTimeMillis() - start_time;
        total_time += elapsed_time;
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17710().mark();
    }
}
