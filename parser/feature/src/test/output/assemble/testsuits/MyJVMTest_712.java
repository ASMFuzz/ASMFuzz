import java.util.Arrays;

public class MyJVMTest_712 {

    static int runCount = 0;

    static String levels = "b5Y 1^K~x)";

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
        System.out.println(Arrays.asList(new MyJVMTest_712().getRunStarts(runCount, levels)));
    }
}
