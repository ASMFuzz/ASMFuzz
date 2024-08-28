public class MyJVMTest_15311 {

    static int global = 7;

    static int gl_unopt = 4;

    static int gl_opt = 2;

    static int a_one = 1;

    static int zero = 0;

    void increment_unopt() {
        gl_unopt += a_one;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15311().increment_unopt();
    }
}
