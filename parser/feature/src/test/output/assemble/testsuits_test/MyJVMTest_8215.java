public class MyJVMTest_8215 {

    static int fail = 0;

    static int pass = 0;

    static Throwable first = null;

    static long KSIZE = 1024;

    static String name = "B3\\/#c(Vm,";

    static long total = 6781903853011884635L;

    static long free = 9223372036854775807L;

    void reset() {
        fail = 0;
        pass = 0;
        first = null;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8215().reset();
    }
}
