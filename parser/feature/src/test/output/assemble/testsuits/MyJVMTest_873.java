import java.io.PrintStream;

public class MyJVMTest_873 {

    static String[] args = { "];\\vZMI%HV", "SkJXf$!:..", "qR&S6B'M9R", "yV\"u!\"^}A1", "QOQB=^k0tD", "`?U}\\=1q#Z", "XOHYRY?H]v", ".jI51kS)z9", "-Kx\\O[%^bJ", "`fFg;uZ%|`" };

    static String outParam1 = "+b7lAnFKZB";

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
        stack011[] threads = new stack011[THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new stack011();
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
        System.out.println(new MyJVMTest_873().run(args, out));
    }
}
