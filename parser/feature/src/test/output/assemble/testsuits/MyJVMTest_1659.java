public class MyJVMTest_1659 {

    static long iterations = 3195917673991591765L;

    void call() {
    }

    long test(long iterations) {
        for (long j = 0; j < iterations; j++) {
            call();
        }
        return iterations;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1659().test(iterations);
    }
}
