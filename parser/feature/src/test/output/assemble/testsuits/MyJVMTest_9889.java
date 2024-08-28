import java.util.Arrays;

public class MyJVMTest_9889 {

    static int runCount = 2;

    static String levels = "M!Nt!9H!G~";

    static char R = '\u202F';

    int[] getRunStarts(int runCount, String levels) {
        int[] array = new int[runCount];
        int len = levels.length();
        char c = levels.charAt(0);
        int i = 1;
        for (int index = 1; index < len; index++) {
            if (levels.charAt(index) != c) {
                c = levels.charAt(index);
                array[i++] = index;
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9889().getRunStarts(runCount, levels)));
    }
}
