import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_2445 {

    static String[] args = { "zJMZ{{Z|pZ", "!i{$Y&|5gm", "~pkM.T9!Pw", "7(5s?u4h.C", "S2HjOE+Z$-", "gsd(`Q%OKs", "As)G~XAaNG", "6x8P6*n`by", "n~O@/&(zB7", "%Tl.g}W\\Sp" };

    static String outParam1Param1 = "T3Mlc9OvQ ";

    static File outParam1 = new File(outParam1Param1);

    static String outParam2 = ";QCKVyL9=+";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    int run(String[] args, PrintStream out) {
        for (int depth = 100; ; depth += 100) try {
            recurse(depth);
        } catch (Error error1) {
            if (!(error1 instanceof StackOverflowError) && !(error1 instanceof OutOfMemoryError))
                throw error1;
            out.println("Max. depth: " + depth);
            try {
                recurse(10 * depth);
                out.println("?");
            } catch (Error error2) {
                if (!(error2 instanceof StackOverflowError) && !(error2 instanceof OutOfMemoryError))
                    throw error2;
            }
            break;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2445().run(args, out));
    }
}
