public class MyJVMTest_4198 {

    static String args = "/9u4Mkl1s_";

    void f(String... args) {
    }

    String g(String... args) {
        f(args);
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4198().g(args);
    }
}
