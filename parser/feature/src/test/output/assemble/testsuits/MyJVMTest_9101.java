public class MyJVMTest_9101 {

    static String str = "jMOdEvu>u`";

    static boolean laxLineEndings = false;

    String patternQuote(String str) {
        return str.replaceAll("([\\\\\\[\\].^$?*+{}()|])", "\\\\$1");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9101().patternQuote(str));
    }
}
