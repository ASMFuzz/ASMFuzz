import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_11133 {

    static String[] args = { "c0F9va~n=5", "`k{t&aN U*", "=.0{JOr@3g", "U?mDv;7$J/", "]0LbZutXf3", "C)c\\|.lgbM", "'agT;{R_rZ", "r/hD4f7ZU|", "#_G8kN~ea3", "!_uKK59.w$" };

    static String outParam1Param1 = "3|7Ih`5=h.";

    static File outParam1 = new File(outParam1Param1);

    static String outParam2 = "iYnr\"&Pj\\e";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    int run(String[] args, PrintStream out) {
        stack005 test = new stack005();
        int depth;
        for (depth = 100; ; depth += 100) try {
            test.recurse(depth);
        } catch (StackOverflowError soe) {
            break;
        } catch (OutOfMemoryError oome) {
            break;
        }
        out.println("Max. depth: " + depth);
        for (int i = 0; i < 100; i++) try {
            test.recurse(2 * depth);
            out.println("?");
        } catch (StackOverflowError soe) {
        } catch (OutOfMemoryError oome) {
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11133().run(args, out));
    }
}
