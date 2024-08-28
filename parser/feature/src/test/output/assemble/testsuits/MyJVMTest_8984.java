public class MyJVMTest_8984 {

    static String suffix = "zK!>p8*v=#";

    static String debug = "SgTIBCI;!B";

    String getId(String suffix) {
        if (debug != null) {
            return debug + "." + suffix;
        } else {
            return System.identityHashCode(this) + "." + suffix;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8984().getId(suffix));
    }
}
