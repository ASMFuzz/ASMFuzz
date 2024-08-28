public class MyJVMTest_11642 {

    static int max = 7;

    boolean booleanInvert(final int max) {
        boolean test1 = false;
        boolean test2 = false;
        for (int i = 0; i < max; i++) {
            test1 = !test1;
        }
        for (int i = 0; i < max; i++) {
            test2 ^= true;
        }
        if (test1 != test2) {
            System.out.println("ERROR: Boolean invert\n\ttest1=" + test1 + "\n\ttest2=" + test2);
            System.exit(97);
        } else {
            System.out.println("Passed!");
        }
        return test1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11642().booleanInvert(max);
    }
}
