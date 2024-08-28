public class MyJVMTest_4452 {

    static String s = "css";

    static String t = "cst";

    static String u = "csu";

    String o() {
        return "cso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4452().o());
    }
}
