public class MyJVMTest_5752 {

    static String s = "ass";

    static String t = "ast";

    static String u = "asu";

    String xm() {
        return "xasm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5752().xm());
    }
}
