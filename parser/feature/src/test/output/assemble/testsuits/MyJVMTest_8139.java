public class MyJVMTest_8139 {

    static long start_time = 9223372036854775807L;

    static long elapsed_time = 9223372036854775807L;

    static long total_time = 0L;

    void mark() {
        elapsed_time = System.currentTimeMillis() - start_time;
        total_time += elapsed_time;
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8139().mark();
    }
}
