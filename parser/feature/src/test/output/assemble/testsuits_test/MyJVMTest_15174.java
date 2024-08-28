public class MyJVMTest_15174 {

    static String s = "ass";

    static String t = "ast";

    static String u = "asu";

    String o() {
        return "aso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15174().o());
    }
}
