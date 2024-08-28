public class MyJVMTest_4847 {

    static String s = "ass";

    static String t = "ast";

    static String u = "asu";

    String m() {
        return "asm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4847().m());
    }
}
