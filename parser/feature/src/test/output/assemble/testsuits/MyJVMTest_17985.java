public class MyJVMTest_17985 {

    static String s = "bss";

    static String t = "bst";

    static String u = "bsu";

    String n() {
        return "bsn";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17985().n());
    }
}
