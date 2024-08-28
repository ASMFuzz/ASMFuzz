public class MyJVMTest_13948 {

    static String[] args = { "$BC>N#`{af", "#_y]Yguz`3", "+P{N]TW=q$", "7tqQ0L&\\Yz", "##@D$G\\qqR", "4'?MFO&e*(", ":^w}C%WvBW", "~s>~9mLZt\\", ")x!s!tQA4X", "4=W9 ~zha=" };

    static String match = "FvK+@xaHi;";

    boolean _match(String[] args, String match) {
        boolean toRet = false;
        for (int i = 0; !toRet && (i < args.length); i++) {
            toRet = match.equals(args[i]);
        }
        return toRet;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13948()._match(args, match));
    }
}
