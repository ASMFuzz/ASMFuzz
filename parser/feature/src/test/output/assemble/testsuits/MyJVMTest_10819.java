import java.io.PrintStream;

public class MyJVMTest_10819 {

    static String[] args = { "S&S_n,<%Q1", "hr);=^Pr21", "ij,Fm,93WR", "o)p2dMhwB`", "EQ4QaT9$7)", ";,nwO&R5}v", "80^VA>Q[<S", ";z}YAK{]1c", "{|tc-3p9me", "=qt=F[OD\"E" };

    static String outParam1 = "5{!?@1&9cJ";

    static String outParam2 = "Ni|l;}[!Sg";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    int doRun(String[] args, PrintStream out) {
        int depth;
        for (depth = 100; ; depth += 100) try {
            recurse(depth);
        } catch (StackOverflowError soe) {
            break;
        } catch (OutOfMemoryError oome) {
            break;
        }
        out.println("Max. depth: " + depth);
        for (int i = 0; i < 100; i++) try {
            recurse(2 * depth);
            out.println("?");
        } catch (StackOverflowError soe) {
        } catch (OutOfMemoryError oome) {
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10819().doRun(args, out));
    }
}
