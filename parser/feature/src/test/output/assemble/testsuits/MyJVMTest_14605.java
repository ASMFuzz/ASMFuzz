import java.io.PrintStream;

public class MyJVMTest_14605 {

    static int cnt = 0;

    static long duration = 2946582995700408725L;

    static boolean verbose = false;

    static int noThreads = 5;

    static PrintStream out = null;

    void describe() {
        out.println("DurAllocator run: ");
        out.println("   test duration:     " + duration / 1000 + " seconds");
        out.println("   number of threads: " + noThreads + " threads");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14605().describe();
    }
}
