public class MyJVMTest_12315 {

    static String lvalue = "s#0~4-*$bx";

    static String expr = "c*G.cafafp";

    static String cmd = "fqG&Caijv`";

    JdbCommand set(String lvalue, String expr) {
        return new JdbCommand("set " + lvalue + " = " + expr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12315().set(lvalue, expr));
    }
}
