public class MyJVMTest_14247 {

    static String s = "ass";

    static String t = "ast";

    static String u = "asu";

    String m() {
        return "asm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14247().m());
    }
}
