public class MyJVMTest_13561 {

    static String args = "TkhW.|WLEH";

    void f(String... args) {
    }

    String g(String... args) {
        f(args);
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13561().g(args);
    }
}
