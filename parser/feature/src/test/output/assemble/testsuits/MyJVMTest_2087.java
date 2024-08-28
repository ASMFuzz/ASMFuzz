public class MyJVMTest_2087 {

    static String s = "iac^Um]h6S";

    String r(String s) {
        return s == null ? null : (s + "@REALM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2087().r(s));
    }
}
