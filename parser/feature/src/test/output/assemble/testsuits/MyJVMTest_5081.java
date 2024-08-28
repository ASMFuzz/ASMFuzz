public class MyJVMTest_5081 {

    static String expr = "21/Poj-^zf";

    static String cmd = "y}Pir`=A.J";

    JdbCommand eval(String expr) {
        return new JdbCommand("eval " + expr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5081().eval(expr));
    }
}
