public class MyJVMTest_1213 {

    static String s1 = "m@*qIto*+$";

    static String s2 = "<Xt|<[fl('";

    boolean equal(String s1, String s2) {
        return (s1 == null ? s2 == null : s1.equals(s2));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1213().equal(s1, s2));
    }
}
