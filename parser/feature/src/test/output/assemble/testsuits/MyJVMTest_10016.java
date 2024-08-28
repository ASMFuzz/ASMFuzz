public class MyJVMTest_10016 {

    static String levels = "'qt1h=ljSd";

    static char R = '\u202F';

    int getRunCount(String levels) {
        int len = levels.length();
        char c = levels.charAt(0);
        int runCount = 1;
        for (int index = 1; index < len; index++) {
            if (levels.charAt(index) != c) {
                runCount++;
                c = levels.charAt(index);
            }
        }
        return runCount;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10016().getRunCount(levels));
    }
}
