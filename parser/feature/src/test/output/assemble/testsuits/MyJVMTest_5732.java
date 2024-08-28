public class MyJVMTest_5732 {

    static String s = "ass";

    static String t = "ast";

    static String u = "asu";

    String o() {
        return "aso";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5732().o());
    }
}
