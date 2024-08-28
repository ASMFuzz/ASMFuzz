import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_8245 {

    static String[] args = { "^EGSxjG*F~", "WI\"dPo>pX}", "S+|yaNpPS\"", "t3\"A'<}4\"f", "h}v(.xoM/c", "di4pE/ERm[", ".~~8|uQ$7j", "#^22\"=Zn2,", "4atW>4*8x#", "ps1Q.,-031" };

    static OutputStream outParam1 = new ByteArrayOutputStream();

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
        System.out.println(new MyJVMTest_8245().run(args, out));
    }
}
