import java.util.Random;

public class MyJVMTest_9369 {

    static int count = 0;

    static int SMALL_LEN = 16;

    static int MAX_TESTS = 10;

    static int SMALL_INTS_LEN = 3;

    static int SMALL_BYTES_LEN = 80;

    static byte[] bytesA = {-100,-62,-51,107,30,-87,74,113,-78,-107}, bytesB = {-11,50,-24,-50,4,-98,-42,-105,101,42}, bytesC = {-17,111,-120,115,12,-81,-54,-118,101,-47}, bytesD = {2,110,-89,-35,-31,81,-14,12,-91,115};

    static short[] shortsA = {-32768,-32768,-32768,-32768,-380,-32768,-32768,7534,32767,-4834}, shortsB = {32767,11725,32767,0,-32768,0,0,0,-32768,0}, shortsC = {-32768,-32768,-8380,-28249,-32768,-32768,-32323,0,32767,-3986}, shortsD = {0,-14038,0,-32768,-32768,0,0,0,32767,32767};

    static char[] charsA = {'I',Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'#',Character.MAX_VALUE}, charsB = {'s','0','&',Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0','y',Character.MIN_VALUE}, charsC = {'0','0','0','a',Character.MIN_VALUE,Character.MIN_VALUE,'0','0','0','e'};

    static int[] intsA = {-1085959967,7,1558524046,1810832027,6,0,833935446,0,7,-1446884985}, intsB = {0,1,0,9,1,5,5,2,6,0}, intsC = {272806084,0,-568646299,0,4,1258658118,3,0,9,1};

    static long[] longsA = {9223372036854775807L,-8397416460579187622L,9223372036854775807L,9223372036854775807L,0,-9223372036854775808L,0,0,0,0}, longsB = {0,9223372036854775807L,0,8341780628552224439L,0,9223372036854775807L,-9223372036854775808L,-2124587444897539813L,9223372036854775807L,8324437868975876582L}, longsC = {-774682190582513492L,9223372036854775807L,-9223372036854775808L,-9223372036854775808L,-7630029818539413230L,0,9223372036854775807L,-9223372036854775808L,-2191820720807176239L,-4339778872380909277L};

    static byte[][] gBytes = {{76,63,-87,-79,42,-43,-61,58,11,-13},{-12,99,-54,7,-102,-77,-1,-60,113,-87}};

    static short[][] gShorts = {{-32768,0,32767,0,0,0,24107,0,0,0},{0,-32768,-32768,-32768,0,-14811,-32097,32767,-32768,-32768}};

    static char[][] gChars = {{'5',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'0'},{'2','0','?','h',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'0','$',Character.MIN_VALUE}};

    static int[][] gInts = {{1324935022,6,8,2,0,0,6,4,0,1929059921},{2,0,2,6,1645899925,0,5,4,2,1}};

    static long[][] gLongs = {{-9223372036854775808L,-9223372036854775808L,9223372036854775807L,-5546378534846855180L,-9223372036854775808L,-8047549312358060231L,9223372036854775807L,-9223372036854775808L,-8504817376686059737L,2810249207399633602L},{0,6216571857036989802L,0,0,9223372036854775807L,-9223372036854775808L,0,0,-9223372036854775808L,0}};

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
        new MyJVMTest_9369().test_init(count);
    }
}
