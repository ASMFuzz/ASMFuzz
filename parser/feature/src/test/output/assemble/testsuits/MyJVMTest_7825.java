import java.io.PrintStream;

public class MyJVMTest_7825 {

    static String[] args = { "I6 Lab5*u5", "*0ZP+'xb{g", "D&Q%xqaiIf", "dzUAJ:;WYu", "QlZ/0V1s,T", "4u&|&2,%#P", ">m!k|Q`{>v", "Rf0;\"tJ&LM", "A ^x]+NlR,", "@0@5oH+Mjr" };

    static String outParam1 = "bSLUyC#\"$[";

    static String outParam2 = "Pac2g>\\H:'";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int THREADS = 10;

    static int depthToTry = 0;

    static Throwable thrown = null;

    int run(String[] args, PrintStream out) {
        stack012 test = new stack012();
        int maxDepth = 0;
        for (int depth = 10; ; depth += 10) try {
            test.recurse(depth);
            maxDepth = depth;
        } catch (StackOverflowError soe) {
            break;
        } catch (OutOfMemoryError oome) {
            break;
        }
        out.println("Max. depth: " + maxDepth);
        stack012[] threads = new stack012[THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new stack012();
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
        System.out.println(new MyJVMTest_7825().run(args, out));
    }
}
