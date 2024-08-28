import java.util.Arrays;

public class MyJVMTest_6984 {

    static int runCount = 0;

    static String levels = "A8b1LJ:9Df";

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
        System.out.println(Arrays.asList(new MyJVMTest_6984().getRunLevels_int(runCount, levels)));
    }
}
