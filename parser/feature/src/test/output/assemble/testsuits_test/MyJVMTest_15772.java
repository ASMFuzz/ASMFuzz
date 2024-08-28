import java.io.PrintStream;

public class MyJVMTest_15772 {

    static String outParam1 = "(K[~%/.M2v";

    static String outParam2 = "ap.ErH&(xh";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    static String context = "\\59#@+Jr$v";

    static long sampleCount = -9223372036854775808L;

    static long[] disparity = {0,9223372036854775807L,-9223372036854775808L,3319749196187856141L,9223372036854775807L,0,-4357310906561006978L,5166926881632841160L,0,0};

    static long sumPopCount = 0;

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
        new MyJVMTest_15772().printStats(out, context);
    }
}
