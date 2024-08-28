import java.io.PrintStream;
import java.net.URI;
import java.io.File;

public class MyJVMTest_1900 {

    static String[] args = { "tA#pUUq1&\"", "<WWKLrGJ!@", "4e:D1!+|b|", "9VkLW+P&BQ", "q6`/y#Q6#2", "lI&-JT/w#x", "IA_]vWf60>", "r}*#Q0DYTJ", "H;PY=+o~b\\", "K{GZb.')\"!" };

    static String outParam1Param1Param1 = "x$UFU0E3#|";

    static String outParam1Param1Param2 = ")v:6u65jB8";

    static String outParam1Param1Param3 = "Ls$6dac,^L";

    static String outParam1Param1Param4 = "3#{6q4s]F9";

    static URI outParam1Param1 = new URI(outParam1Param1Param1, outParam1Param1Param2, outParam1Param1Param3, outParam1Param1Param4);

    static File outParam1 = new File(outParam1Param1);

    static String outParam2 = "n\"{!)S65AT";

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
        System.out.println(new MyJVMTest_1900().run(args, out));
    }
}
