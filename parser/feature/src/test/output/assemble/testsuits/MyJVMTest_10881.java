public class MyJVMTest_10881 {

    static long iterations = -6249677289870741662L;

    void call() {
    }

    long test(long iterations) {
        for (long j = 0; j < iterations; j++) {
            call();
        }
        return iterations;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10881().test(iterations);
    }
}
