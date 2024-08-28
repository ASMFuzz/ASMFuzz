public class MyJVMTest_952 {

    static String expr = "n#&G7azAsE";

    static String cmd = "Z9m/)*Xc}u";

    JdbCommand lock(String expr) {
        return new JdbCommand("lock " + expr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_952().lock(expr));
    }
}
