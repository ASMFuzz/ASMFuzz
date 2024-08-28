public class MyJVMTest_12860 {

    static String msg = "aS?-QPVVLT";

    static E arr = null;

    static int length = 0;

    static int fromPos = 3;

    static int toPos = 5;

    static byte[] fromByteArr = {-2,-79,-40,88,-5,-78,35,-111,16,-110}, toByteArr = {-27,-40,-6,-82,13,-115,-25,19,86,-45};

    static char[] fromCharArr = {Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'5'}, toCharArr = {'Y',Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'d','0','0',Character.MAX_VALUE,'0',Character.MIN_VALUE};

    static int[] fromIntArr = {632131684,5,9,613841958,8,4,0,4,4,2}, toIntArr = {8,0,0,5,912201555,-545280315,-1677739667,-1907237964,0,114760338};

    static long[] fromLongArr = {6315797680588654246L,1191972450425107530L,0,0,-9223372036854775808L,9223372036854775807L,0,0,0,8870325039027811910L}, toLongArr = {9223372036854775807L,-9223372036854775808L,0,9223372036854775807L,0,-1112241740406363876L,9223372036854775807L,9223372036854775807L,0,9223372036854775807L};

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
        new MyJVMTest_12860().validate(msg, arr, length, fromPos, toPos);
    }
}
