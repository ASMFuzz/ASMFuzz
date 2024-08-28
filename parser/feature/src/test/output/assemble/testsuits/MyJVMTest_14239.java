import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_14239 {

    static String[] args = { "ZbQcUJHaHy", "bo$t[:n-f\"", "f/P\"\"9t>nD", "&h~/HR*df-", "/hW^@td<o<", "F9fDw~S9!>", " .eu+>,yW/", "\"g?#B;OyFn", "dY,V&Ud7f@", "0hm*lT/|/I" };

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static PrintStream out = new PrintStream(outParam1);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int THREADS = 10;

    static int CYCLES = 10;

    int run(String[] args, PrintStream out) {
        stack013i test = new stack013();
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
        stack013i[] threads = new stack013i[THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new stack013();
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
        System.out.println(new MyJVMTest_14239().run(args, out));
    }
}
