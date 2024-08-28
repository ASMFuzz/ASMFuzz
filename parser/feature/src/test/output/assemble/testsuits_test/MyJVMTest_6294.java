import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_6294 {

    static int outParam1Param1 = 712;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static PrintStream out = new PrintStream(outParam1);

    static String context = "?}P34H{CWX";

    static long sampleCount = 7835676218479783194L;

    static long[] disparity = {9223372036854775807L,0,-6578266115807566329L,0,0,0,9223372036854775807L,6735572913635551349L,0,9223372036854775807L};

    static long sumPopCount = 9223372036854775807L;

    PrintStream printStats(PrintStream out, String context) {
        out.print(context + " bit disparities: ");
        int wordDisparity = 0;
        int wordAbsoluteDisparity = 0;
        for (int i = 0; i < 32; ++i) {
            long bitDisparity = disparity[i];
            wordDisparity += bitDisparity;
            wordAbsoluteDisparity += (bitDisparity < 0) ? -bitDisparity : bitDisparity;
            out.print(bitDisparity + ", ");
        }
        out.print('\n');
        String result = String.format("%1$10s disparity: %2$8d average population count %3$3d", context, wordAbsoluteDisparity, sumPopCount / sampleCount);
        out.println(result);
        if (false) {
            out.print("\n" + context + " word disparity: " + wordDisparity);
            out.print(" word absolute disparity: " + wordAbsoluteDisparity);
            out.println(" average population count: " + sumPopCount / sampleCount);
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6294().printStats(out, context);
    }
}
