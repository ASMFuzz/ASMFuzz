public class MyJVMTest_7580 {

    static int i = 0;

    static double d = 0.08502749330113135;

    static String s = "=.je2(~29W";

    static int si = 4;

    static String ss = "q9Y9c$,0:U";

    static int effects = 0;

    int checkEffects(int i) throws Exception {
        if (effects != 1) {
            AccessMethodsLHS.fail("incorrect side-effect behavior (" + effects + "): " + i);
        }
        effects = 0;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7580().checkEffects(i);
    }
}
