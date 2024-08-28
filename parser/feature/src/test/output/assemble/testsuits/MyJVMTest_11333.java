public class MyJVMTest_11333 {

    static String s = "}W2[YrLosw";

    String r(String s) {
        return s == null ? null : (s + "@REALM");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11333().r(s));
    }
}
