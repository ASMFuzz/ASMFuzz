public class MyJVMTest_5622 {

    static String s = "bss";

    static String t = "bst";

    static String u = "bsu";

    String o() {
        return "bso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5622().o());
    }
}
