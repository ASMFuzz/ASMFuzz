public class MyJVMTest_15674 {

    static String[] args = { "DVnWqI)pM6", "|<]\\PuDo;,", "Vk_rng~2Y>", "vSc<'+a>jz", "?)P9o>n(?+", "6l5zeDp3s5", ":XypC&(fu!", "*D_/EK|`s)", "?qXS@8?{3h", "QK\\FQC4$G[" };

    static String keyword = "$C*4D 38jQ";

    static int defaultValue = 5;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static double start = 0.0;

    static double left = 0d;

    static double right = Double.NaN;

    static double area = 0d;

    int intArg(String[] args, String keyword, int defaultValue) {
        String val = keywordValue(args, keyword);
        return (val == null) ? defaultValue : Integer.parseInt(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15674().intArg(args, keyword, defaultValue));
    }
}
