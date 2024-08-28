public class MyJVMTest_11806 {

    static long start_time = -9223372036854775808L;

    void reset() {
        start_time = System.currentTimeMillis();
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11806().reset();
    }
}
