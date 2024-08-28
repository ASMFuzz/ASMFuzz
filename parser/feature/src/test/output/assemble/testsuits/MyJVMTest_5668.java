import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_5668 {

    static String[] args = { "c&Ha(<=k?v", "JZB+X,*T!+", "D+Fj*F'sV5", "=iUx'[J:e$", "['V?H,Fe:o", "50Pf7dBg}g", "^vsCzE21S^", "Y#6!R[E  c", ")$^_wST=>`", "U<}:O.]Szc" };

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static boolean outParam2 = false;

    static String outParam3 = ")TBlsI.3*1";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int ITERATIONS = 1000;

    static int INCREMENT = 100;

    int run(String[] args, PrintStream out) {
        stack007i test = new stack007();
        int depth;
        for (depth = 100; ; depth += INCREMENT) try {
            test.recurse(depth);
        } catch (StackOverflowError soe) {
            break;
        } catch (OutOfMemoryError oome) {
            break;
        }
        out.println("Max. depth: " + depth);
        for (int i = 0; i < ITERATIONS; i++) try {
            test.recurse(10 * depth);
            out.println("?");
        } catch (StackOverflowError soe) {
        } catch (OutOfMemoryError oome) {
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5668().run(args, out));
    }
}
