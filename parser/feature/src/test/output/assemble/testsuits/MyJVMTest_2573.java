public class MyJVMTest_2573 {

    static int SIZE = 4096;

    static byte[] fromByteArr = {-46,14,-57,92,-61,43,37,-38,85,67}, toByteArr = {28,-5,58,-76,-84,70,-121,-118,7,-114};

    static char[] fromCharArr = {Character.MIN_VALUE,'6',Character.MIN_VALUE,'h',Character.MAX_VALUE,'0',Character.MAX_VALUE,Character.MIN_VALUE,'T',Character.MIN_VALUE}, toCharArr = {'b','0',Character.MIN_VALUE,Character.MIN_VALUE,'C',Character.MAX_VALUE,Character.MIN_VALUE,'>','z',Character.MIN_VALUE};

    static int[] fromIntArr = {0,-1856214951,2,0,0,0,0,0,2,6}, toIntArr = {1,-1709960887,0,0,3,0,0,4,2,1550038920};

    static long[] fromLongArr = {0,0,-4764440203034181394L,8027935610934827522L,-7360516889196875596L,-9223372036854775808L,9223372036854775807L,0,9223372036854775807L,9223372036854775807L}, toLongArr = {-9223372036854775808L,-9223372036854775808L,-9223372036854775808L,-9223372036854775808L,9223372036854775807L,8372555973997760592L,-9223372036854775808L,-9223372036854775808L,0,-9223372036854775808L};

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
        new MyJVMTest_2573().setup();
    }
}
