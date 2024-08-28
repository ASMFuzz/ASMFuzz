public class MyJVMTest_17659 {

    static String suffix = "I?\\{N6p&An";

    static String debug = "GN]_$]e4&a";

    String getId(String suffix) {
        if (debug != null) {
            return debug + "." + suffix;
        } else {
            return System.identityHashCode(this) + "." + suffix;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17659().getId(suffix));
    }
}
