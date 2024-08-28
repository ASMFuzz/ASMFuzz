import java.util.Arrays;

public class MyJVMTest_217 {

    static String[] args = { "83_C-=(|ZD", "(9X}Oh~@\"i", "wU2z.6(E!`", "b0P+d9 ^;O", "kuRO/RJJi/", "W0V`}z3oWO", "a5@MO^IMc~", "|%5dbHE]}@", "4}V@B{:4mG", "wTN{`f(,`y" };

    static String keyword = "gArNxbZmG0";

    static int[] sofar = {0,0,-577281712,1760600066,6,0,0,1680348336,0,0};

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_217().keywordValue(args, keyword));
    }
}
