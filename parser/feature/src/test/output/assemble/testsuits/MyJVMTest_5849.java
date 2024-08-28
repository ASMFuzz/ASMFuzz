public class MyJVMTest_5849 {

    static String[] args = { "dUQxPRAV+|", "2U]HS@KO9m", "6XS]egX6cu", "gq_P=L>a=<", ")6n;xU\\.U*", "X\\CSFt~5*^", "r]4Xof25BS", "VdchYz^eZ_", "cMyA~]ZN;%", "z1EbVI`rLE" };

    static String keyword = "}ZloGj1;Ct";

    static String name = ")(OFDV0$Qj";

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5849().keywordValue(args, keyword));
    }
}
