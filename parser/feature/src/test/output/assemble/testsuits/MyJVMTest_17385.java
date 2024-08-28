import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_17385 {

    static String[] args = { "(nvF~~eQfy", "JL7r1wppI1", "ED{mH]U^f:", ")N&?6-ijlT", "O]*1@5Bfu6", "}<S\"i<Xq_\\", "}CkQ:},fE6", "vma=S`x Bc", ".:($Go}BQl", "?I)M}p|d|," };

    static String outParam1Param1 = "%wDzbJu#5b";

    static String outParam1Param2 = "u9QOud)6JO";

    static File outParam1 = new File(outParam1Param1, outParam1Param2);

    static PrintStream out = new PrintStream(outParam1);

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
        System.out.println(new MyJVMTest_17385().run(args, out));
    }
}
