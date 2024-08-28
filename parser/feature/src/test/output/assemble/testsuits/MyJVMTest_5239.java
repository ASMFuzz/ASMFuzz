import java.io.PrintStream;

public class MyJVMTest_5239 {

    static String[] args = { "[[UEOPi0rQ", "VFi`zX`=tH", "Ti=9V**s@R", "W^ut3P%~@d", ":j|n|M5p't", "s|/$|'mSw/", "X%2)WxV n]", "z?5p8f2}f<", "PO#1G2!&'>", "khVD&`'vC*" };

    static String outParam1 = "p%XDWKheVy";

    static String outParam2 = "d|SR5\\%8%V";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    void recurse(int depth) {
        if (depth > 0)
            recurse(depth - 1);
    }

    int run(String[] args, PrintStream out) {
        stack006i test = new stack006();
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
        System.out.println(new MyJVMTest_5239().run(args, out));
    }
}
