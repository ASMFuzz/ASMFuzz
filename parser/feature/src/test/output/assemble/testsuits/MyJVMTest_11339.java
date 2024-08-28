import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_11339 {

    static String[] args = { "#^H3* 9v'3", "*_l3bHkxKQ", "P0{p3%r_?,", ">NH&Qp4tM-", "3M79rv1%h9", "T&\"oj,1?;5", "N+CP(Z7mxh", "lb+i_f2H`9", "0*5fG#Pc!M", "c|7UrW||6]" };

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static boolean outParam2 = true;

    static String outParam3 = "N|Z.L *<qP";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

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
        System.out.println(new MyJVMTest_11339().run(args, out));
    }
}
