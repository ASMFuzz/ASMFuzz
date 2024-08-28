public class MyJVMTest_12442 {

    static Class<?> c = null;

    static int SIZE = 4096;

    static byte[] fromByteArr = {34,82,-35,-58,-99,76,-30,-3,84,-107}, toByteArr = {-67,-54,-7,-126,116,-1,104,69,69,-2}, valByteArr = {-33,-116,63,50,116,-33,104,-74,74,-118};

    static char[] fromCharArr = {'R','D',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'b','0','0','0','h'}, toCharArr = {Character.MAX_VALUE,'0',Character.MAX_VALUE,Character.MIN_VALUE,'0','0','0','0',Character.MAX_VALUE,Character.MIN_VALUE}, valCharArr = {'t',Character.MIN_VALUE,'x',Character.MAX_VALUE,'0','1',Character.MIN_VALUE,'0','0','D'};

    static int[] fromIntArr = {0,0,-1616970490,3,-1115650919,385903924,3,2,0,7}, toIntArr = {3,-414925794,6,0,0,0,-1300098127,7,6,5}, valIntArr = {5,1782832180,7,0,0,0,539404723,3,0,0};

    static long[] fromLongArr = {-9223372036854775808L,-9223372036854775808L,0,9223372036854775807L,6930574966432268911L,9223372036854775807L,0,9223372036854775807L,9223372036854775807L,9223372036854775807L}, toLongArr = {9223372036854775807L,0,9223372036854775807L,8363750496569512106L,-9223372036854775808L,-7016981955105643568L,0,9223372036854775807L,-96536955367945832L,-9223372036854775808L}, valLongArr = {-7754805994177276935L,1025525411910801230L,-8952501528638206637L,9052752829787819334L,-3229673155472323916L,6296759731998957454L,-9223372036854775808L,0,0,-3485819648970975074L};

    Class<?> reinit(Class<?> c) {
        if (c == byte.class) {
            for (int i = 0; i < SIZE; i++) {
                fromByteArr[i] = (byte) i;
            }
        } else if (c == char.class) {
            for (int i = 0; i < SIZE; i++) {
                fromCharArr[i] = (char) i;
            }
        } else if (c == int.class) {
            for (int i = 0; i < SIZE; i++) {
                fromIntArr[i] = i;
            }
        } else {
            assert c == long.class;
            for (int i = 0; i < SIZE; i++) {
                fromLongArr[i] = i;
            }
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12442().reinit(c);
    }
}
