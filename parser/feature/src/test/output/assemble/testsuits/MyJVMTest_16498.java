import java.util.Arrays;

public class MyJVMTest_16498 {

    static int runCount = 4;

    static String levels = "HJ@] )CLa0";

    static char L = '\u200E';

    static char R = '\u202F';

    int[] getRunLevels_int(int runCount, String levels) {
        int[] array = new int[runCount];
        int len = levels.length();
        char c = levels.charAt(0);
        int i = 0;
        array[i++] = c - '0';
        for (int index = 1; index < len; index++) {
            if (levels.charAt(index) != c) {
                c = levels.charAt(index);
                array[i++] = c - '0';
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16498().getRunLevels_int(runCount, levels)));
    }
}
