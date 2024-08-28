import java.util.Arrays;

public class MyJVMTest_12653 {

    static int runCount = 0;

    static String levels = ":mh7J`KG2[";

    static char L = '\u200E';

    static char R = '\u202F';

    int[] getRunLimits(int runCount, String levels) {
        int[] array = new int[runCount];
        int len = levels.length();
        char c = levels.charAt(0);
        int i = 0;
        for (int index = 1; index < len; index++) {
            if (levels.charAt(index) != c) {
                c = levels.charAt(index);
                array[i++] = index;
            }
        }
        array[i] = len;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12653().getRunLimits(runCount, levels)));
    }
}
