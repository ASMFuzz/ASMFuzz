public class MyJVMTest_14494 {

    static String expr = "o#Ys;\\}QbE";

    static String cmd = "DynK9Go,l>";

    JdbCommand eval(String expr) {
        return new JdbCommand("eval " + expr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14494().eval(expr));
    }
}
