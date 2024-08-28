public class MyJVMTest_11851 {

    static int SIZE = 4096;

    static byte[] fromByteArr = {77,97,23,87,-39,11,14,67,-1,97}, toByteArr = {70,-121,122,22,-20,-34,36,77,27,-32};

    static char[] fromCharArr = {'0','0','0',Character.MAX_VALUE,'0',Character.MIN_VALUE,'b','0','i','b'}, toCharArr = {Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'g','0',Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0','8'};

    static int[] fromIntArr = {-1077368282,0,1,-1369152374,3,0,0,1814961035,-1208509285,0}, toIntArr = {2,9,370229536,7,5,8,2,7,0,1};

    static long[] fromLongArr = {-9223372036854775808L,-9223372036854775808L,0,0,-9223372036854775808L,-9223372036854775808L,-9223372036854775808L,9223372036854775807L,9223372036854775807L,0}, toLongArr = {-9223372036854775808L,9223372036854775807L,0,0,8440552105338592097L,-8971521477347399955L,9223372036854775807L,0,9223372036854775807L,-9223372036854775808L};

    void setup() {
        fromByteArr = new byte[SIZE];
        toByteArr = new byte[SIZE];
        fromCharArr = new char[SIZE];
        toCharArr = new char[SIZE];
        fromIntArr = new int[SIZE];
        toIntArr = new int[SIZE];
        fromLongArr = new long[SIZE];
        toLongArr = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            fromByteArr[i] = (byte) i;
            fromCharArr[i] = (char) i;
            fromIntArr[i] = i;
            fromLongArr[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11851().setup();
    }
}
