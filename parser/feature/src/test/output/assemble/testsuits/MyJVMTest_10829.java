public class MyJVMTest_10829 {

    static String s = "bss";

    static String t = "bst";

    static String u = "bsu";

    String m() {
        return "bsm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10829().m());
    }
}
