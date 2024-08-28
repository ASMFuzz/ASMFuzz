public class MyJVMTest_17374 {

    static String[] args = { "v\\N]}n53lJ", "FeCs44ap?.", "K|{gX'qf+:", "gF]$,\"q`F!", "k'7(aPQsbd", "tZ!_AMf9;R", "T,Kuj*qR5H", "DNm<H[;7Gu", ">QDXD6f]B!", "z%YET|IJ,c" };

    static String keyword = "plhU|X$kzJ";

    static int defaultValue = 9;

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static String name = "3N6[>o8xV3";

    int intArg(String[] args, String keyword, int defaultValue) {
        String val = keywordValue(args, keyword);
        return val == null ? defaultValue : Integer.parseInt(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17374().intArg(args, keyword, defaultValue));
    }
}
