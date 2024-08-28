public class MyJVMTest_9028 {

    static String AGENT_LIB = "SuspendAtExit";

    static int DEF_TIME_MAX = 30;

    void usage() {
        System.err.println("Usage: " + AGENT_LIB + " [time_max]");
        System.err.println("where:");
        System.err.println("    time_max ::= max looping time in seconds");
        System.err.println("                 (default is " + DEF_TIME_MAX + " seconds)");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9028().usage();
    }
}
