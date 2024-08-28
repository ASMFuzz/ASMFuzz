public class MyJVMTest_8089 {

    static String suffix = "f+G0fro%ys";

    static String debug = ";}ASn6t%ka";

    String getId(String suffix) {
        if (debug != null) {
            return debug + "." + suffix;
        } else {
            return System.identityHashCode(this) + "." + suffix;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8089().getId(suffix));
    }
}
