public class MyJVMTest_9732 {

    static String s = "css";

    static String t = "cst";

    static String u = "csu";

    String m() {
        return "csm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9732().m());
    }
}
