import java.text.*;

public class MyJVMTest_11002 {

    static long n = 9223372036854775807L;

    static int nwords = -2038662897;

    static int BYTES_PER_WORD = 4;

    static long youngBytes = 0;

    static int[] aexport = {6,6,8,0,0,1,1466626362,3,-1097331799,1182842406};

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
        new MyJVMTest_11002().doYoungGenAlloc(n, nwords);
    }
}
