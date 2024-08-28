public class MyJVMTest_8914 {

    static int DEF_TIME_MAX = 30;

    static String PROG_NAME = "StopAtExit";

    void usage() {
        System.err.println("Usage: " + PROG_NAME + " [time_max]");
        System.err.println("where:");
        System.err.println("    time_max  max looping time in seconds");
        System.err.println("              (default is " + DEF_TIME_MAX + " seconds)");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8914().usage();
    }
}
