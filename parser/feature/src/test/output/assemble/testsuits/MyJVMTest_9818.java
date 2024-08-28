import java.io.*;

public class MyJVMTest_9818 {

    static String fParam1 = ":jd.UAcN#{";

    static File f = new File(fParam1);

    static long nt = -9223372036854775808L;

    static long rt = 9223372036854775807L;

    long ck(File f, long nt, long rt) throws Exception {
        if (rt == nt)
            return;
        if ((rt / 10 == nt / 10) || (rt / 100 == nt / 100) || (rt / 1000 == nt / 1000) || (rt / 10000 == (nt / 10000))) {
            System.err.println(f + ": Time set to " + nt + ", rounded down by filesystem to " + rt);
            return;
        }
        if ((rt / 10 == (nt + 5) / 10) || (rt / 100 == (nt + 50) / 100) || (rt / 1000 == (nt + 500) / 1000) || (rt / 10000 == ((nt + 5000) / 10000))) {
            System.err.println(f + ": Time set to " + nt + ", rounded up by filesystem to " + rt);
            return;
        }
        throw new Exception(f + ": Time set to " + nt + ", then read as " + rt);
        return nt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9818().ck(f, nt, rt);
    }
}
