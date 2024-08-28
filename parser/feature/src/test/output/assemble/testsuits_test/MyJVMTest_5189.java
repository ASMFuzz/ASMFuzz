import java.io.PrintStream;

public class MyJVMTest_5189 {

    static int cnt = 2;

    static long duration = 9223372036854775807L;

    static boolean verbose = false;

    static int noThreads = 5;

    static PrintStream out = null;

    void describe() {
        out.println("DurAllocator run: ");
        out.println("   test duration:     " + duration / 1000 + " seconds");
        out.println("   number of threads: " + noThreads + " threads");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5189().describe();
    }
}
