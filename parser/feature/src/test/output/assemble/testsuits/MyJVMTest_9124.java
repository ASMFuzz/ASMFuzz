public class MyJVMTest_9124 {

    static String s1 = ".l*iI.i~*l";

    static String s2 = "IL}4BO:;'M";

    boolean equal(String s1, String s2) {
        return (s1 == null ? s2 == null : s1.equals(s2));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9124().equal(s1, s2));
    }
}
