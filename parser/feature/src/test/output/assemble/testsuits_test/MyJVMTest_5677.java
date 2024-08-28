import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_5677 {

    static String[] args = { "1B}-KJzY*8", "x;>>Gp*)~z", "\\c$rZ#iyp]", " `XO!+q}?x", "&G[6!/L)?V", "CK=WP4CM/m", "]P%:EQp_SD", "z4$l*,dp)&", "j0i4v(/n]*", "3Qf0`I_0DJ" };

    static String outParam1Param1 = "d{O{;+ZG(f";

    static String outParam1Param2 = "e?n.~CA>~X";

    static File outParam1 = new File(outParam1Param1, outParam1Param2);

    static String outParam2 = "+9 igf^^<B";

    static PrintStream out = new PrintStream(outParam1, outParam2);

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
        System.out.println(new MyJVMTest_5677().run(args, out));
    }
}
