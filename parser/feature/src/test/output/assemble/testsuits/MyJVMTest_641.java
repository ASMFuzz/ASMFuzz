public class MyJVMTest_641 {

    static int global = 4;

    static int gl_unopt = 3;

    static int gl_opt = 2;

    static int a_one = 0;

    static int zero = 9;

    void increment_opt() {
        gl_opt += a_one;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_641().increment_opt();
    }
}
