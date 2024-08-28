public class MyJVMTest_11362 {

    static String s = "cs";

    static String t = "ct";

    static String u = "cu";

    String o() {
        return "co";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11362().o());
    }
}
