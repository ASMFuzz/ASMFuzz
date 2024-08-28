import java.util.*;

public class MyJVMTest_12873 {

    static String[] args = { "q=> M)LMf4", "h(d\"Fk\\T*G", "E;'>CAN!(x", "%bM;kgE9y9", ")[qb!g+}3P", "A?%=22_3){", "K&NucuC!J5", "2HL8he\\UH\"", "8}U7u{ZPyg", "oTi`S\\M\\.p" };

    static String keyword = "Omy}BQ_[LR";

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static String name = "s,-p*T(qE0";

    java.util.regex.Pattern patternArg(String[] args, String keyword) {
        String val = keywordValue(args, keyword);
        return val == null ? null : java.util.regex.Pattern.compile(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12873().patternArg(args, keyword));
    }
}
