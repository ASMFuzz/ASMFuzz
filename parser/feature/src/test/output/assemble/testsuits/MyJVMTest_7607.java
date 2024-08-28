public class MyJVMTest_7607 {

    static String x = "@y8ZQ{V%,8";

    static Exception theCheckedException = new Exception("The checked exception that should be seen");

    String setCheckedException(String x) throws Exception {
        throw theCheckedException;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7607().setCheckedException(x);
    }
}
