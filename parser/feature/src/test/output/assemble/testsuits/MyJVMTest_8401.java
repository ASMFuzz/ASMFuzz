public class MyJVMTest_8401 {

    static String s = "bss";

    static String t = "bst";

    static String u = "bsu";

    String n() {
        return "bsn";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8401().n());
    }
}
