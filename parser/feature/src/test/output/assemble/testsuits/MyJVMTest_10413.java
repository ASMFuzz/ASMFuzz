public class MyJVMTest_10413 {

    static String s1 = "wBlym@g-MQ";

    static String s2 = "1RmN[.`_6l";

    boolean equal(String s1, String s2) {
        return (s1 == null ? s2 == null : s1.equals(s2));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10413().equal(s1, s2));
    }
}
