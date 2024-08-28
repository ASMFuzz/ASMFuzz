public class MyJVMTest_2532 {

    static long start_time = 9223372036854775807L;

    void reset() {
        start_time = System.currentTimeMillis();
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2532().reset();
    }
}
