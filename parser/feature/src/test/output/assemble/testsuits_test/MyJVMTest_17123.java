public class MyJVMTest_17123 {

    static int i = 0;

    static double d = 0d;

    static String s = "`![hg:b^c-";

    static int si = 5;

    static String ss = "7:`O\"&A5Pu";

    static int effects = 0;

    int checkEffects(int i) throws Exception {
        if (effects != 1) {
            AccessMethodsLHS.fail("incorrect side-effect behavior (" + effects + "): " + i);
        }
        effects = 0;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17123().checkEffects(i);
    }
}
