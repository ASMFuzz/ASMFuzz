public class MyJVMTest_10136 {

    static String expr = "B0$.~=z.{Q";

    static String cmd = "Li4m.%QiHP";

    JdbCommand lock(String expr) {
        return new JdbCommand("lock " + expr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10136().lock(expr));
    }
}
