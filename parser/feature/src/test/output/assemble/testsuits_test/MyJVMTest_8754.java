public class MyJVMTest_8754 {

    static String AGENT_LIB = "SuspendWithObjectMonitorWait";

    static int DEF_TIME_MAX = 60;

    void usage() {
        System.err.println("Usage: " + AGENT_LIB + " [-p][time_max]");
        System.err.println("where:");
        System.err.println("    -p       ::= print debug info");
        System.err.println("    time_max ::= max looping time in seconds");
        System.err.println("                 (default is " + DEF_TIME_MAX + " seconds)");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8754().usage();
    }
}
