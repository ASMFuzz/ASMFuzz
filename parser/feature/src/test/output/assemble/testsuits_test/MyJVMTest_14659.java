import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_14659 {

    static String[] args = { "|hqw8;h~4&", "@xSW%F%iL7", "DxH.'3N~A`", "}zXwKT2SM2", ".a<EPM42L.", "Sls[v4IL1H", "XRcl?]^ULS", "~K2#\\qo$h{", "gLyv1~t]M|", " LmQ=Oa$Ky" };

    static int outParam1Param1 = 59;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static boolean outParam2 = true;

    static String outParam3 = "x>r\"SKhJAU";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

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
        System.out.println(new MyJVMTest_14659().run(args, out));
    }
}
