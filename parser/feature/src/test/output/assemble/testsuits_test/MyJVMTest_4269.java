import java.util.Arrays;

public class MyJVMTest_4269 {

    static int runCount = 3;

    static String levels = "q~mG{K*?HZ";

    static char L = '\u200E';

    static char R = '\u202F';

    byte[] getRunLevels_byte(int runCount, String levels) {
        byte[] array = new byte[runCount];
        int len = levels.length();
        char c = levels.charAt(0);
        int i = 0;
        array[i++] = (byte) (c - '0');
        for (int index = 1; index < len; index++) {
            if (levels.charAt(index) != c) {
                c = levels.charAt(index);
                array[i++] = (byte) (c - '0');
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4269().getRunLevels_byte(runCount, levels)));
    }
}
