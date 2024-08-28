import java.io.PrintStream;

public class MyJVMTest_2093 {

    static String[] args = { "G ?_mz\"FW#", "*?RR)Kv|</", "IdSctyOoNf", "pWJHu(oV[\"", "hqc<9#j\"$A", "wGHuxF00jA", "l/7dFls@73", "i!A^vQ3L&>", "Z>V$923ceX", "auc{waA.m|" };

    static String outParam1 = "SjY|(9A]1f";

    static PrintStream out = new PrintStream(outParam1);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int THREADS = 10;

    static int depthToTry = 0;

    static Throwable thrown = null;

    int run(String[] args, PrintStream out) {
        int maxDepth = 0;
        for (int depth = 10; ; depth += 10) try {
            recurse(depth);
            maxDepth = depth;
        } catch (StackOverflowError soe) {
            break;
        } catch (OutOfMemoryError oome) {
            break;
        }
        out.println("Max. depth: " + maxDepth);
        stack010[] threads = new stack010[THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new stack010();
            threads[i].depthToTry = 10 * maxDepth;
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) if (threads[i].isAlive())
            try {
                threads[i].join();
            } catch (InterruptedException exception) {
                exception.printStackTrace(out);
                return 2;
            }
        int exitCode = 0;
        for (int i = 0; i < threads.length; i++) if (threads[i].thrown != null) {
            threads[i].thrown.printStackTrace(out);
            exitCode = 2;
        }
        if (exitCode != 0)
            out.println("# TEST FAILED");
        return exitCode;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2093().run(args, out));
    }
}
