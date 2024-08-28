import java.io.PrintStream;

public class MyJVMTest_1598 {

    static String[] args = { "cD3AR~poiO", "53<I<gCYay", "{cAU*#{)\\T", "k&rW36Xc1-", "GYlLX[beRe", "][#,]LJUjQ", "!f[z!qePPU", "r'=VhzYwqA", "JfsL-E YbH", "@7DSEg*Z\"I" };

    static String outParam1 = "1jh*a&\",w&";

    static PrintStream out = new PrintStream(outParam1);

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
        System.out.println(new MyJVMTest_1598().doRun(args, out));
    }
}
