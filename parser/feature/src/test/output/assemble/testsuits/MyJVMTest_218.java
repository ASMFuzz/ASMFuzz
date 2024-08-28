import java.util.Random;

public class MyJVMTest_218 {

    static int count = 0;

    static int SMALL_LEN = 16;

    static int MAX_TESTS = 10;

    static int SMALL_INTS_LEN = 3;

    static int SMALL_BYTES_LEN = 80;

    static byte[] bytesA = {-99,4,6,0,113,7,-10,64,-86,14}, bytesB = {-27,83,-5,-34,-71,35,14,24,-51,126}, bytesC = {51,-66,109,-119,-93,92,117,-35,69,-69}, bytesD = {-18,-7,39,15,111,-101,-55,97,108,19};

    static short[] shortsA = {-32768,1630,-32768,32767,0,26086,30668,32767,-32768,0}, shortsB = {-10147,-32768,4597,-32768,-32768,7681,-32768,32767,0,-5154}, shortsC = {32767,32767,0,0,32767,-32768,-32768,-32768,32355,0}, shortsD = {32767,954,-32768,0,-32768,-23841,-9232,0,17261,-32768};

    static char[] charsA = {Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'S','0','i','0','$',Character.MIN_VALUE,Character.MIN_VALUE}, charsB = {'0','0','0','0','0','j',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'_'}, charsC = {'o','>',Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE};

    static int[] intsA = {0,0,0,741533787,0,-401804659,0,6,5,-1214536089}, intsB = {0,1,1,0,7,0,0,0,1,2}, intsC = {0,0,1,9,0,786095941,7,9,-1465165588,-603832511};

    static long[] longsA = {0,1966006711571746206L,9223372036854775807L,9223372036854775807L,1086885652642987110L,0,-1010575009155761861L,-9223372036854775808L,3982985106411614453L,-9223372036854775808L}, longsB = {5338005486064790798L,0,-9223372036854775808L,-9223372036854775808L,-9223372036854775808L,9223372036854775807L,9223372036854775807L,9223372036854775807L,-9223372036854775808L,0}, longsC = {9223372036854775807L,-5734160708325856753L,5042164545923030919L,0,6037574676688591012L,9223372036854775807L,-6968669773872830145L,-9223372036854775808L,0,-9223372036854775808L};

    static byte[][] gBytes = {{48,122,54,-67,71,113,-49,63,-89,86},{109,101,-27,2,53,104,98,-1,3,52}};

    static short[][] gShorts = {{0,0,32767,0,-31719,0,0,32767,-32768,-32768},{32767,-6532,0,-32768,506,0,-10492,32767,-21360,6849}};

    static char[][] gChars = {{Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0','0','2',Character.MAX_VALUE,'_',Character.MIN_VALUE},{'*',Character.MAX_VALUE,Character.MAX_VALUE,':','0',Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'0'}};

    static int[][] gInts = {{0,-712440392,2,1549476362,8,2,0,0,-1686697216,8},{-413205456,4,-1946028020,8,9,0,8,0,8,5}};

    static long[][] gLongs = {{0,-5842563893931060584L,9223372036854775807L,3103776655247287150L,0,-9223372036854775808L,9223372036854775807L,-9223372036854775808L,-9223372036854775808L,0},{1718839069720943906L,9223372036854775807L,0,9223372036854775807L,-290849056687650912L,9223372036854775807L,-9223372036854775808L,-9223372036854775808L,0,9223372036854775807L}};

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
        new MyJVMTest_218().test_init(count);
    }
}
