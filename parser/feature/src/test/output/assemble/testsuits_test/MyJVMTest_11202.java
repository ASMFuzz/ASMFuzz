public class MyJVMTest_11202 {

    static long x = -9223372036854775808L;

    static String w = "cu]6.wW\"@B";

    String inspect(final long x, final String w) {
        return w + ": long";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11202().inspect(x, w));
    }
}
