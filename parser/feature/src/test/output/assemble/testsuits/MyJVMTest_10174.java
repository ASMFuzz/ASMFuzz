public class MyJVMTest_10174 {

    static String[] args = { "dy%y^}Do3>", "KaOz)Jg,`v", "(*(VA=gn61", "N`\"POdTyX\\", "z3$u2C10;~", "/Yz #whn\\%", "hMY)eyz$hH", "6as6E,NTee", "^+(hJHEVg\\", "ei~`Rf!w(=" };

    static String keyword = "FI4)`1/G)D";

    static int defaultPolicy = -1703365397;

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

    static double area = Double.MIN_VALUE;

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
        System.out.println(new MyJVMTest_10174().policyArg(args, keyword, defaultPolicy));
    }
}
