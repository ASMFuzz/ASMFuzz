import java.io.PrintStream;

public class MyJVMTest_15113 {

    static String[] args = { "fML;.aj{cd", "=xcC@\\1*}H", "@B'R/o6:$L", "=~zq9Cdc%2", "e:\\rg]`U$I", "GG,.!`QG^Y", "8(~\"Cl7<-\\", "A#*{yHea/Y", "07oKh$c]7t", "*dOEH,q~Hv" };

    static String outParam1 = "~(d`Mf1$t5";

    static PrintStream out = new PrintStream(outParam1);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int THREADS = 10;

    static int CYCLES = 10;

    int run(String[] args, PrintStream out) {
        stack014i test = new stack014();
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
        stack014i[] threads = new stack014i[THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new stack014();
            threads[i].depthToTry = 10 * maxDepth;
            threads[i].cycles = CYCLES;
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
        System.out.println(new MyJVMTest_15113().run(args, out));
    }
}
