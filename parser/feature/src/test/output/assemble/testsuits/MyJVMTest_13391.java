public class MyJVMTest_13391 {

    static String s = "css";

    static String t = "cst";

    static String u = "csu";

    String n() {
        return "csn";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13391().n());
    }
}
