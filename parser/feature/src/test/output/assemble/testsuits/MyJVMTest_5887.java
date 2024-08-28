public class MyJVMTest_5887 {

    static String s = "XT'fulZlK(";

    static Throwable first = null;

    static long KSIZE = 1024;

    static String name = "Cbm/Wx#9cr";

    static long total = -9223372036854775808L;

    static long free = -9223372036854775808L;

    String setFirst(String s) {
        if (first == null) {
            first = new RuntimeException(s);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5887().setFirst(s);
    }
}
