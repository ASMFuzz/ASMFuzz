import java.util.Arrays;

public class MyJVMTest_7129 {

    static int runCount = 5;

    static String text = "Icf.]pr8ZC";

    static String levels = "-zn^%Bh)bS";

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

    static char L = '\u200E';

    static char R = '\u202F';

    String[] getObjects(int runCount, String text, String levels) {
        String[] array = new String[runCount];
        int[] runLimits = getRunLimits(runCount, levels);
        int runStart = 0;
        for (int i = 0; i < runCount; i++) {
            array[i] = text.substring(runStart, runLimits[i]);
            runStart = runLimits[i];
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7129().getObjects(runCount, text, levels)));
    }
}
