import java.util.*;

public class MyJVMTest_15093 {

    static boolean reportConsumedMemory = true;

    static boolean Verbose = false;

    static String name = "LL9Bsfu<Ni";

    long stabilizeMemory(boolean reportConsumedMemory) {
        final long oneMegabyte = 1024L * 1024L;
        long refMemory = 0;
        long initialMemoryLeft = Runtime.getRuntime().freeMemory();
        long currMemoryLeft = initialMemoryLeft;
        int nbGCCalls = 0;
        do {
            nbGCCalls++;
            refMemory = currMemoryLeft;
            System.gc();
            currMemoryLeft = Runtime.getRuntime().freeMemory();
        } while ((Math.abs(currMemoryLeft - refMemory) > oneMegabyte) && (nbGCCalls < 10));
        if (Verbose && reportConsumedMemory)
            System.out.println("Memory consumed by previous run : " + (currMemoryLeft - initialMemoryLeft) / oneMegabyte + "Mbs.");
        return currMemoryLeft;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15093().stabilizeMemory(reportConsumedMemory));
    }
}
