public class MyJVMTest_11420 {

    static String s = "cs";

    static String t = "ct";

    static String u = "cu";

    String m() {
        return "cm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11420().m());
    }
}
