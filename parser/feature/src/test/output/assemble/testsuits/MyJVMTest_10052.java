import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_10052 {

    static String[] args = { "PumX RN]w?", "Y(EA=q6#|7", " %;goBSYYF", "a+%ojTbP$s", " l!i,4fu#X", "xz#F x1g<(", "y6*Zr6<Q!o", ")b;m7d'RW,", "iOy E4*bqs", "4-aV0+/&5>" };

    static int outParam1Param1 = 415;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

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
        System.out.println(new MyJVMTest_10052().run(args, out));
    }
}
