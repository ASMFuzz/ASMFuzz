public class MyJVMTest_3127 {

    static Class<?> c = null;

    static int SIZE = 4096;

    static byte[] fromByteArr = {-10,87,-34,-119,20,-103,80,-107,-60,-79}, toByteArr = {98,-66,26,-71,104,-94,-97,-28,-17,106}, valByteArr = {126,52,34,26,92,90,-12,-104,109,60};

    static char[] fromCharArr = {'0','0',Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'2',Character.MIN_VALUE}, toCharArr = {'X',Character.MIN_VALUE,Character.MIN_VALUE,'6','3',Character.MIN_VALUE,Character.MIN_VALUE,'7',Character.MIN_VALUE,Character.MIN_VALUE}, valCharArr = {Character.MIN_VALUE,Character.MIN_VALUE,'0','0',Character.MIN_VALUE,'0','0',Character.MAX_VALUE,Character.MIN_VALUE,'0'};

    static int[] fromIntArr = {-155161597,3,3,0,7,4,454980297,4,1,-263562888}, toIntArr = {2,0,1,-1509178282,5,0,0,-1459815861,1,1}, valIntArr = {1,-1800582890,8,2,678985996,1,9,4,0,0};

    static long[] fromLongArr = {5415471114496034610L,142841713617911659L,-9223372036854775808L,2364256038731080795L,2114995565807194052L,0,-6613310159378346282L,-9223372036854775808L,0,7051523708613170734L}, toLongArr = {0,0,0,-9223372036854775808L,9223372036854775807L,-5838959525031658786L,1171901620263569943L,5612325673252927550L,-9223372036854775808L,9223372036854775807L}, valLongArr = {-9223372036854775808L,9223372036854775807L,9223372036854775807L,-5056115753694238128L,9223372036854775807L,-9223372036854775808L,0,0,0,1012770937204349736L};

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
        new MyJVMTest_3127().reinit(c);
    }
}
