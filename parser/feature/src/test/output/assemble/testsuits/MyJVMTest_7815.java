public class MyJVMTest_7815 {

    static String[] args = { "suHzFfaJMm", "WAPD_%jeK{", "+-e;DNCpR ", ",lM1/S]7$\\", "d*up@TiZNY", "T.3hIYz\\%;", "-L<*QC\"qO?", "oPqDKK8e[[", ")&v'*oBO?v", "D<KxuN 9[ " };

    static String keyword = "G&blt%SQ/V";

    static int defaultValue = 0;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static String name = "Mv,kWzn +?";

    int intArg(String[] args, String keyword, int defaultValue) {
        String val = keywordValue(args, keyword);
        return val == null ? defaultValue : Integer.parseInt(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7815().intArg(args, keyword, defaultValue));
    }
}
