public class MyJVMTest_12581 {

    static int SIZE = 4096;

    static byte[] fromByteArr = {88,32,50,38,110,-31,123,-121,-91,-24}, toByteArr = {-121,67,-58,-32,33,83,-60,52,-126,-48}, valByteArr = {74,-79,54,-5,-56,9,-48,-24,14,-106};

    static char[] fromCharArr = {Character.MAX_VALUE,'=',Character.MIN_VALUE,'g',Character.MIN_VALUE,'0',Character.MAX_VALUE,Character.MAX_VALUE,'t',Character.MIN_VALUE}, toCharArr = {'C',Character.MIN_VALUE,'0','y',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'n',Character.MAX_VALUE}, valCharArr = {Character.MIN_VALUE,'/','0','0','q','0','0','0','0',Character.MAX_VALUE};

    static int[] fromIntArr = {4,-1521085874,-1046035499,1713767651,0,-255808509,6,0,3,4}, toIntArr = {0,2,3,9,6,2,0,7,0,0}, valIntArr = {8,1783670173,904387647,2,2116657807,0,0,761715105,0,754330961};

    static long[] fromLongArr = {-9223372036854775808L,0,-9223372036854775808L,9223372036854775807L,9223372036854775807L,-9223372036854775808L,9223372036854775807L,-9223372036854775808L,9223372036854775807L,4405449605866343193L}, toLongArr = {0,-9223372036854775808L,-9223372036854775808L,-9223372036854775808L,1869153249385695604L,9223372036854775807L,0,-5332339497987622792L,9223372036854775807L,0}, valLongArr = {-9223372036854775808L,0,6322293202937636234L,-9223372036854775808L,0,0,-9223372036854775808L,9223372036854775807L,672827035170223099L,9223372036854775807L};

    void setup() {
        fromByteArr = new byte[SIZE];
        valByteArr = new byte[SIZE];
        toByteArr = fromByteArr;
        fromCharArr = new char[SIZE];
        valCharArr = new char[SIZE];
        toCharArr = fromCharArr;
        fromIntArr = new int[SIZE];
        valIntArr = new int[SIZE];
        toIntArr = fromIntArr;
        fromLongArr = new long[SIZE];
        valLongArr = new long[SIZE];
        toLongArr = fromLongArr;
        for (int i = 0; i < SIZE; i++) {
            fromByteArr[i] = (byte) i;
            valByteArr[i] = (byte) i;
            fromCharArr[i] = (char) i;
            valCharArr[i] = (char) i;
            fromIntArr[i] = i;
            valIntArr[i] = i;
            fromLongArr[i] = i;
            valLongArr[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12581().setup();
    }
}
