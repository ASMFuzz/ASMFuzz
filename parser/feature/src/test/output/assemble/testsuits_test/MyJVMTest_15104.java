import java.io.PrintStream;

public class MyJVMTest_15104 {

    static String[] args = { ";4mpl$IRgE", "uo@:=g!6pV", "ob~&D|p-|?", "aLC>fKuUiI", "Y*3J)_?y21", "Wi*}Vv}.Fz", "TL;|:,8#M^", "Lwr|Y-Vdng", "ds][^>Yrg=", "2r\"eja4\\p|" };

    static String outParam1 = "Ex/3],nD`g";

    static PrintStream out = new PrintStream(outParam1);

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
        System.out.println(new MyJVMTest_15104().run(args, out));
    }
}
