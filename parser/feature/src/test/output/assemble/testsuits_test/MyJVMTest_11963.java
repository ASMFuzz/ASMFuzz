public class MyJVMTest_11963 {

    static String s = "cs";

    static String t = "ct";

    static String u = "cu";

    String n() {
        return "cn";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11963().n());
    }
}
