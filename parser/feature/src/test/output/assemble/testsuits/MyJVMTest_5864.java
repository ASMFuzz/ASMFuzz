public class MyJVMTest_5864 {

    static int global = 0;

    static int gl_unopt = 0;

    static int gl_opt = 1053353071;

    static int a_one = -1315481547;

    static int zero = 0;

    void increment_unopt() {
        gl_unopt += a_one;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5864().increment_unopt();
    }
}
