public class MyJVMTest_17789 {

    static int fail = 0;

    static int pass = 0;

    static Throwable first = null;

    static long KSIZE = 1024;

    static String name = "KS=R5o0|:M";

    static long total = 0;

    static long free = 0;

    void reset() {
        fail = 0;
        pass = 0;
        first = null;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17789().reset();
    }
}
