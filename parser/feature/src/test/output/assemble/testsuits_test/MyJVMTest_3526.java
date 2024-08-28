public class MyJVMTest_3526 {

    static String msg = "6zK%fX`awH";

    static E arr = null;

    static int length = 8;

    static int fromPos = 593106755;

    static int toPos = 0;

    static byte[] fromByteArr = {72,116,31,30,45,54,27,104,75,78}, toByteArr = {40,70,33,89,2,1,-113,-17,-34,92};

    static char[] fromCharArr = {Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MAX_VALUE,Character.MAX_VALUE,'W','/','U',Character.MAX_VALUE,'0'}, toCharArr = {Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE,'4',Character.MAX_VALUE,'0',Character.MAX_VALUE,'0','0'};

    static int[] fromIntArr = {1867558776,9,4,6,0,5,4,74695140,3,3}, toIntArr = {0,1718739122,9,1,0,0,0,0,0,-1547984249};

    static long[] fromLongArr = {-8341631853584347582L,9223372036854775807L,0,-1087807301417303676L,-8815164718696326859L,9223372036854775807L,-4669759823366994307L,7008274786519548804L,-9223372036854775808L,-8771146963066097524L}, toLongArr = {9223372036854775807L,-5255056166316450829L,-9223372036854775808L,0,9223372036854775807L,0,0,-9223372036854775808L,0,9223372036854775807L};

    static int validate_ctr = 0;

    <E> int validate(String msg, E arr, int length, int fromPos, int toPos) {
        validate_ctr++;
        if (arr instanceof byte[]) {
            byte[] barr = (byte[]) arr;
            for (int i = 0; i < length; i++) if (fromByteArr[i + fromPos] != barr[i + toPos]) {
                System.out.println(msg + "[" + arr.getClass() + "] Result mismtach at i = " + i + " expected = " + fromByteArr[i + fromPos] + " actual   = " + barr[i + toPos] + " fromPos = " + fromPos + " toPos = " + toPos);
                throw new Error("Fail");
            }
        } else if (arr instanceof char[]) {
            char[] carr = (char[]) arr;
            for (int i = 0; i < length; i++) if (fromCharArr[i + fromPos] != carr[i + toPos]) {
                System.out.println(msg + "[" + arr.getClass() + "] Result mismtach at i = " + i + " expected = " + fromCharArr[i + fromPos] + " actual   = " + carr[i + toPos] + " fromPos = " + fromPos + " toPos = " + toPos);
                throw new Error("Fail");
            }
        } else if (arr instanceof int[]) {
            int[] iarr = (int[]) arr;
            for (int i = 0; i < length; i++) if (fromIntArr[i + fromPos] != iarr[i + toPos]) {
                System.out.println(msg + "[" + arr.getClass() + "] Result mismtach at i = " + i + " expected = " + fromIntArr[i + fromPos] + " actual   = " + iarr[i + toPos] + " fromPos = " + fromPos + " toPos = " + toPos);
                throw new Error("Fail");
            }
        } else if (arr instanceof long[]) {
            long[] larr = (long[]) arr;
            for (int i = 0; i < length; i++) if (fromLongArr[i + fromPos] != larr[i + toPos]) {
                System.out.println(msg + "[" + arr.getClass() + "] Result mismtach at i = " + i + " expected = " + fromLongArr[i + fromPos] + " actual   = " + larr[i + toPos] + " fromPos = " + fromPos + " toPos = " + toPos);
                throw new Error("Fail");
            }
        }
        return toPos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3526().validate(msg, arr, length, fromPos, toPos);
    }
}
