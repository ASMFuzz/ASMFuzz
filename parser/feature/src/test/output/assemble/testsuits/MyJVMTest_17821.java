import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_17821 {

    static String[] args = { "j#40<9KO{[", "G)fR>`( q(", "\\0DG.9qVxj", "pa,fF$lH?Y", "qWbfT^qPMD", "9h|<9*sM4`", "|v{Sr2k[P%", "ak~'!SqkE.", "&r^T_H O`?", "x+tuNR[{A;" };

    static int outParam1Param1 = 959;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static PrintStream out = new PrintStream(outParam1);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    static int ITERATIONS = 100;

    static int INCREMENT = 100;

    int run(String[] args, PrintStream out) {
        int depth;
        for (depth = 1; ; depth += INCREMENT) try {
            recurse(depth);
        } catch (StackOverflowError soe) {
            break;
        } catch (OutOfMemoryError oome) {
            break;
        }
        out.println("Max. depth: " + depth);
        for (int i = 0; i < ITERATIONS; i++) try {
            recurse(2 * depth);
            out.println("?");
        } catch (StackOverflowError soe) {
        } catch (OutOfMemoryError oome) {
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17821().run(args, out));
    }
}
