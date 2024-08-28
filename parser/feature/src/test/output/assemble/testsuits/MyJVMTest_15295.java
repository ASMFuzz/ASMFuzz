public class MyJVMTest_15295 {

    static String[] args = { "?vgFFr/jX\"", "W6rTjkRS_a", "tmW}Q6G4XO", ".e#T(Z80^n", "[cx(sg&h\"c", ";rI<W*|3,h", "k]!fQT;J/#", "x|nJ#F@qRf", "+qwp) ,eE'", "[02#h@m5=q" };

    static String keyword = "Y ,D*M%Qxg";

    static String name = "`dq-{pm4]G";

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15295().keywordValue(args, keyword));
    }
}
