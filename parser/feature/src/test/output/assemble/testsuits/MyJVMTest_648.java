import java.io.*;

public class MyJVMTest_648 {

    static String fParam1Param1Param1Param1Param1 = ")el\\Ki&.^)";

    static File fParam1Param1Param1Param1 = new File(fParam1Param1Param1Param1Param1);

    static String fParam1Param1Param1Param2 = "vuvyLd=KID";

    static File fParam1Param1Param1 = new File(fParam1Param1Param1Param1, fParam1Param1Param1Param2);

    static String fParam1Param1Param2 = ")ze_/T[&r=";

    static File fParam1Param1 = new File(fParam1Param1Param1, fParam1Param1Param2);

    static String fParam1Param2 = "5YLB1p^\" Q";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "6(^vY]9VNm";

    static File f = new File(fParam1, fParam2);

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
        new MyJVMTest_648().ck(f, nt, rt);
    }
}
