public class MyJVMTest_9811 {

    static int global = 9;

    static int gl_unopt = 0;

    static int gl_opt = -1280421977;

    static int a_one = 0;

    static int zero = 0;

    void increment_opt() {
        gl_opt += a_one;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9811().increment_opt();
    }
}
