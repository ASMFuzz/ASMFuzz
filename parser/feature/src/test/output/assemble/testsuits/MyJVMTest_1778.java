import java.text.*;

public class MyJVMTest_1778 {

    static long n = 9223372036854775807L;

    static int nwords = 0;

    static int BYTES_PER_WORD = 4;

    static long youngBytes = 0;

    static int[] aexport = {0,-1302028891,6,-662981764,1450865163,1,0,-1768891325,0,0};

    int doYoungGenAlloc(long n, int nwords) {
        final int nbytes = nwords * BYTES_PER_WORD;
        int allocated = 0;
        while (allocated < n) {
            aexport = new int[nwords];
            allocated += nbytes;
        }
        youngBytes = youngBytes + allocated;
        return allocated;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1778().doYoungGenAlloc(n, nwords);
    }
}
