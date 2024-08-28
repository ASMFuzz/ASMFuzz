public class MyJVMTest_6201 {

    static String[] args = { "0cL1=+8d1,", "Ougm~`l6gO", "t~#\"Sh+fz9", ";Z1)0}$5.k", "2% h%voltV", "J/y*hl\"oc8", "_~YL3)|0Bt", "2:F_U[Iog_", "fEqSCa]3xu", "eY,'S\\?!B4" };

    static String keyword = "`KGoxYPhoY";

    static int defaultValue = -385093785;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static double start = 0.0;

    static double left = Double.MAX_VALUE;

    static double right = 0.36186865756384745;

    static double area = Double.NEGATIVE_INFINITY;

    int intArg(String[] args, String keyword, int defaultValue) {
        String val = keywordValue(args, keyword);
        return (val == null) ? defaultValue : Integer.parseInt(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6201().intArg(args, keyword, defaultValue));
    }
}
