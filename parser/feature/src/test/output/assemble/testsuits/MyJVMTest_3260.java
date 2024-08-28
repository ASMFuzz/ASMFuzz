public class MyJVMTest_3260 {

    static int SIZE = 4096;

    static byte[] fromByteArr = {-125,-56,-24,-125,26,14,19,72,-74,-4}, toByteArr = {-85,-97,-54,-69,65,-1,-70,91,66,-51}, valByteArr = {43,-21,97,-56,-19,-86,69,-38,-70,-104};

    static char[] fromCharArr = {Character.MIN_VALUE,Character.MAX_VALUE,'0','0','0',Character.MAX_VALUE,Character.MIN_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE}, toCharArr = {'O','Y',Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0',Character.MIN_VALUE,'1','0','0'}, valCharArr = {'0','_','0','0',Character.MIN_VALUE,'0','0','4',Character.MAX_VALUE,Character.MIN_VALUE};

    static int[] fromIntArr = {-2059782493,799580714,-307662998,7,0,1,8,9,4,9}, toIntArr = {4,6,199153902,1,0,1,8,9,0,3}, valIntArr = {2029924414,0,1108488886,253105923,8,8,0,-1918435819,0,9};

    static long[] fromLongArr = {9223372036854775807L,0,-9223372036854775808L,4938915984879165579L,-2596872566819805384L,0,4016741029602169358L,9223372036854775807L,9223372036854775807L,-9223372036854775808L}, toLongArr = {-9223372036854775808L,0,0,-9223372036854775808L,9223372036854775807L,9223372036854775807L,-9223372036854775808L,0,9223372036854775807L,9223372036854775807L}, valLongArr = {-9223372036854775808L,-9223372036854775808L,-5010909484087035479L,-2742262713640905999L,-9223372036854775808L,7800425859286489011L,3352678958484615084L,0,9223372036854775807L,-9223372036854775808L};

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
        new MyJVMTest_3260().setup();
    }
}
