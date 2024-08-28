import java.util.*;

public class MyJVMTest_3539 {

    static String[] args = { "k\\)1r[T(;1", "pIlX;?@)Ud", "?oz'vx4['h", "*Z#jJ%WLM7", "BIL@_~Jf3\"", "8^7}ps#bz]", "6a>)Nx;qHM", "BsT/AWlqGE", "WOZnod<VK|", "b:p15f_B]c" };

    static String keyword = "a\\5>`PD\"k%";

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    static String name = "c8\\V.:L4'|";

    java.util.regex.Pattern patternArg(String[] args, String keyword) {
        String val = keywordValue(args, keyword);
        return val == null ? null : java.util.regex.Pattern.compile(val);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3539().patternArg(args, keyword));
    }
}
