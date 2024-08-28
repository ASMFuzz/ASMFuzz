public class MyJVMTest_13837 {

    static String s = "css";

    static String t = "cst";

    static String u = "csu";

    String o() {
        return "cso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13837().o());
    }
}
