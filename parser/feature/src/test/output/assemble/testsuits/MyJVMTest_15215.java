public class MyJVMTest_15215 {

    static String s = "ass";

    static String t = "ast";

    static String u = "asu";

    String n() {
        return "asn";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15215().n());
    }
}
