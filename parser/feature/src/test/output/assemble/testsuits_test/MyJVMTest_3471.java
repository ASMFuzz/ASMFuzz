public class MyJVMTest_3471 {

    static String str = "CO2_L yG_\"";

    String toRegExString(String str) {
        String[] tokens = null;
        StringBuilder retStr = new StringBuilder();
        try {
            tokens = str.split(" ");
        } catch (java.util.regex.PatternSyntaxException e) {
            return null;
        }
        for (int x = 0; x < tokens.length; ++x) {
            retStr.append(tokens[x]);
        }
        return retStr.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3471().toRegExString(str));
    }
}
