public class MyJVMTest_17008 {

    static String x = "d$_2xwK^t@";

    String foo(final String x) {
        return "boo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17008().foo(x));
    }
}
