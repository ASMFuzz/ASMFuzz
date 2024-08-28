public class MyJVMTest_1443 {

    static String range = "e-/zG?>7[)";

    static String substr = "]+Wl;G'Lho";

    static String replacement = ":bD0g]sW=`";

    String replaceFirstSubStringMatch(String range, String substr, String replacement) {
        int pos = range.indexOf(substr);
        if (pos == -1) {
            return range;
        } else {
            return range.substring(0, pos) + replacement + range.substring(pos + substr.length());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1443().replaceFirstSubStringMatch(range, substr, replacement));
    }
}
