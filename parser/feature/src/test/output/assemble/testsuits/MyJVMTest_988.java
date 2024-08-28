public class MyJVMTest_988 {

    static String[] args = { "hr\\$hoM`j9", "AIs.bihGz*", "jy-5\" o!+N", "F.-UaXd}t`", "^o6\"$YC}PO", "1b*^]Qr7?Y", "_%<[aWM|ys", "3TWuZ|<O:Q", "@[hzcK.~lQ", "1[`M_PGs2~" };

    static String keyword = "~M_r+!kGm>";

    static int defaultPolicy = 0;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static int SERIAL = -1;

    static int DYNAMIC = 0;

    static int FORK = 1;

    static double start = 0.0;

    static double left = Double.NEGATIVE_INFINITY;

    static double right = Double.NEGATIVE_INFINITY;

    static double area = 0d;

    int policyArg(String[] args, String keyword, int defaultPolicy) {
        String val = keywordValue(args, keyword);
        if (val == null)
            return defaultPolicy;
        if (val.equals("dynamic"))
            return DYNAMIC;
        if (val.equals("serial"))
            return SERIAL;
        if (val.equals("fork"))
            return FORK;
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_988().policyArg(args, keyword, defaultPolicy));
    }
}
