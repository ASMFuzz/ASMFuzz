public class MyJVMTest_3009 {

    static String lvalue = "}}rRx.RyeC";

    static String expr = "[B@,TZ\"`#H";

    static String cmd = "hY*j:N-?VP";

    JdbCommand set(String lvalue, String expr) {
        return new JdbCommand("set " + lvalue + " = " + expr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3009().set(lvalue, expr));
    }
}
