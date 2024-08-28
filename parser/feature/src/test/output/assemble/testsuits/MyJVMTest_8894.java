import java.util.Random;

public class MyJVMTest_8894 {

    static int count = 4;

    static int SMALL_LEN = 16;

    static int MAX_TESTS = 10;

    static int SMALL_INTS_LEN = 3;

    static int SMALL_BYTES_LEN = 80;

    static byte[] bytesA = {-11,-61,114,-128,-101,-77,-52,-123,71,50}, bytesB = {108,62,121,-62,-120,113,123,-49,103,46}, bytesC = {-65,-16,-44,-35,124,32,58,-88,-82,104}, bytesD = {-71,82,-100,61,-100,-98,104,-9,85,110};

    static short[] shortsA = {0,32767,-14554,32767,-32768,19799,-32768,-28993,0,32767}, shortsB = {-32768,0,-32768,-26003,0,0,-26821,0,32767,-32768}, shortsC = {-32768,-32768,25427,13040,0,-32768,-30337,-32768,-32768,32767}, shortsD = {-32768,-32768,-31399,-32768,7304,-32768,0,-32768,32767,-32768};

    static char[] charsA = {'0',Character.MIN_VALUE,Character.MIN_VALUE,'0',Character.MIN_VALUE,'$',Character.MAX_VALUE,'0',Character.MIN_VALUE,'&'}, charsB = {'^','o','0','f','0',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'q'}, charsC = {Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE,'m',Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'C'};

    static int[] intsA = {0,7,0,7,-1493646074,0,88670409,0,0,74910937}, intsB = {0,9,0,-1408614921,0,3,-1710908666,0,0,3}, intsC = {8,464040560,6,0,970340959,623450141,2,756161861,0,8};

    static long[] longsA = {0,9223372036854775807L,9223372036854775807L,4107130773465221171L,9223372036854775807L,-9223372036854775808L,9223372036854775807L,-9223372036854775808L,3120915293247739378L,0}, longsB = {0,-3905693280364707099L,0,9223372036854775807L,9223372036854775807L,9223372036854775807L,9223372036854775807L,-9223372036854775808L,-9223372036854775808L,-9223372036854775808L}, longsC = {0,-9223372036854775808L,-6309542302293675214L,-9223372036854775808L,9223372036854775807L,-9223372036854775808L,-9223372036854775808L,8647629889806120180L,-9223372036854775808L,3680703553434378489L};

    static byte[][] gBytes = {{-59,59,127,-10,-61,-116,1,80,43,4},{-94,-83,-40,-13,-56,118,89,-5,-1,-4}};

    static short[][] gShorts = {{32767,30045,32767,-32768,32767,32767,0,32767,-32768,32767},{0,-18400,32767,-1689,0,0,0,-32768,32767,0}};

    static char[][] gChars = {{'0','0','7','0',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0'},{'g',Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,'z','1',Character.MIN_VALUE,Character.MIN_VALUE}};

    static int[][] gInts = {{4,0,170058590,2,355170369,792786241,0,1,0,8},{2,2,0,9,0,7,0,9,0,4}};

    static long[][] gLongs = {{0,5761422902743185560L,9223372036854775807L,0,9223372036854775807L,0,-9223372036854775808L,9223372036854775807L,-9223372036854775808L,2696019686430591215L},{0,0,0,-9223372036854775808L,-9223372036854775808L,-1395483536306987351L,9223372036854775807L,0,-4761853843460593548L,0}};

    static Random r = new Random(32781);

    int test_init(int count) {
        int countI = count == SMALL_LEN ? SMALL_INTS_LEN : count;
        int countB = count == SMALL_LEN ? SMALL_BYTES_LEN : count;
        bytesA = new byte[countB];
        shortsA = new short[count];
        charsA = new char[count];
        intsA = new int[countI];
        longsA = new long[count];
        bytesB = new byte[countB];
        shortsB = new short[count];
        charsB = new char[count];
        intsB = new int[countI];
        longsB = new long[count];
        bytesC = new byte[countB];
        shortsC = new short[count];
        charsC = new char[count];
        intsC = new int[countI];
        longsC = new long[count];
        bytesD = new byte[countB];
        shortsD = new short[count];
        gBytes = new byte[MAX_TESTS * 2][countB];
        gShorts = new short[MAX_TESTS * 2][count];
        gChars = new char[MAX_TESTS][count];
        gInts = new int[MAX_TESTS][countI];
        gLongs = new long[MAX_TESTS][count];
        for (int i = 0; i < countB; i++) {
            bytesA[i] = (byte) r.nextInt();
            bytesB[i] = (byte) r.nextInt();
            gBytes[0][i] = (byte) (bytesA[i] + (bytesB[i] >> 1));
            gBytes[MAX_TESTS][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[1][i] = (byte) (bytesA[i] + (bytesB[i] >> 8));
            gBytes[MAX_TESTS + 1][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[2][i] = (byte) (bytesA[i] + (bytesB[i] >> 13));
            gBytes[MAX_TESTS + 2][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[3][i] = (byte) (bytesA[i] + (bytesB[i] >> 19));
            gBytes[MAX_TESTS + 3][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[4][i] = (byte) (bytesA[i] + (bytesB[i] >>> 1));
            gBytes[MAX_TESTS + 4][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[5][i] = (byte) (bytesA[i] + (bytesB[i] >>> 8));
            gBytes[MAX_TESTS + 5][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[6][i] = (byte) (bytesA[i] + (bytesB[i] >>> 13));
            gBytes[MAX_TESTS + 6][i] = (byte) (bytesA[i] + bytesB[i]);
            gBytes[7][i] = (byte) (bytesA[i] + (bytesB[i] >>> 19));
            gBytes[MAX_TESTS + 7][i] = (byte) (bytesA[i] + bytesB[i]);
        }
        for (int i = 0; i < count; i++) {
            shortsA[i] = (short) r.nextInt();
            charsA[i] = (char) r.nextInt();
            longsA[i] = r.nextLong();
            shortsB[i] = (short) r.nextInt();
            charsB[i] = (char) r.nextInt();
            longsB[i] = r.nextLong();
        }
        for (int i = 0; i < count; i++) {
            gShorts[0][i] = (short) (shortsA[i] + (shortsB[i] >> 5));
            gShorts[MAX_TESTS][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[1][i] = (short) (shortsA[i] + (shortsB[i] >> 16));
            gShorts[MAX_TESTS + 1][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[2][i] = (short) (shortsA[i] + (shortsB[i] >> 23));
            gShorts[MAX_TESTS + 2][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[3][i] = (short) (shortsA[i] + (shortsB[i] >> 35));
            gShorts[MAX_TESTS + 3][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[4][i] = (short) (shortsA[i] + (shortsB[i] >>> 7));
            gShorts[MAX_TESTS + 4][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[5][i] = (short) (shortsA[i] + (shortsB[i] >>> 16));
            gShorts[MAX_TESTS + 5][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[6][i] = (short) (shortsA[i] + (shortsB[i] >>> 23));
            gShorts[MAX_TESTS + 6][i] = (short) (shortsA[i] + shortsB[i]);
            gShorts[7][i] = (short) (shortsA[i] + (shortsB[i] >>> 35));
            gShorts[MAX_TESTS + 7][i] = (short) (shortsA[i] + shortsB[i]);
            gChars[0][i] = (char) (charsA[i] + (charsB[i] >>> 4));
            gChars[0][i] = (char) (gChars[0][i] + charsA[i] + charsB[i]);
            gChars[1][i] = (char) (charsA[i] + (charsB[i] >>> 16));
            gChars[1][i] = (char) (gChars[1][i] + charsA[i] + charsB[i]);
            gChars[2][i] = (char) (charsA[i] + (charsB[i] >>> 19));
            gChars[2][i] = (char) (gChars[2][i] + charsA[i] + charsB[i]);
            gChars[3][i] = (char) (charsA[i] + (charsB[i] >>> 35));
            gChars[3][i] = (char) (gChars[3][i] + charsA[i] + charsB[i]);
            gLongs[0][i] = longsA[i] + (longsB[i] >> 37);
            gLongs[0][i] = gLongs[0][i] + longsA[i] + longsB[i];
            gLongs[1][i] = longsA[i] + (longsB[i] >> 64);
            gLongs[1][i] = gLongs[1][i] + longsA[i] + longsB[i];
            gLongs[2][i] = longsA[i] + (longsB[i] >> 93);
            gLongs[2][i] = gLongs[2][i] + longsA[i] + longsB[i];
            gLongs[3][i] = longsA[i] + (longsB[i] >> 137);
            gLongs[3][i] = gLongs[3][i] + longsA[i] + longsB[i];
            gLongs[4][i] = longsA[i] + (longsB[i] >>> 37);
            gLongs[4][i] = gLongs[4][i] + longsA[i] + longsB[i];
            gLongs[5][i] = longsA[i] + (longsB[i] >>> 64);
            gLongs[5][i] = gLongs[5][i] + longsA[i] + longsB[i];
            gLongs[6][i] = longsA[i] + (longsB[i] >>> 93);
            gLongs[6][i] = gLongs[6][i] + longsA[i] + longsB[i];
            gLongs[7][i] = longsA[i] + (longsB[i] >>> 137);
            gLongs[7][i] = gLongs[7][i] + longsA[i] + longsB[i];
        }
        for (int i = 0; i < intsA.length; i++) {
            intsA[i] = r.nextInt();
            intsB[i] = r.nextInt();
            gInts[0][i] = intsA[i] + (intsB[i] >> 19);
            gInts[0][i] = gInts[0][i] + intsA[i] + intsB[i];
            gInts[1][i] = intsA[i] + (intsB[i] >> 32);
            gInts[1][i] = gInts[1][i] + intsA[i] + intsB[i];
            gInts[2][i] = intsA[i] + (intsB[i] >> 49);
            gInts[2][i] = gInts[2][i] + intsA[i] + intsB[i];
            gInts[3][i] = intsA[i] + (intsB[i] >> 67);
            gInts[3][i] = gInts[3][i] + intsA[i] + intsB[i];
            gInts[4][i] = intsA[i] + (intsB[i] >>> 19);
            gInts[4][i] = gInts[4][i] + intsA[i] + intsB[i];
            gInts[5][i] = intsA[i] + (intsB[i] >>> 32);
            gInts[5][i] = gInts[5][i] + intsA[i] + intsB[i];
            gInts[6][i] = intsA[i] + (intsB[i] >>> 49);
            gInts[6][i] = gInts[6][i] + intsA[i] + intsB[i];
            gInts[7][i] = intsA[i] + (intsB[i] >>> 67);
            gInts[7][i] = gInts[7][i] + intsA[i] + intsB[i];
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8894().test_init(count);
    }
}
