public class MyJVMTest_1894 {

    static String str = " >)*RF[G#;";

    static boolean laxLineEndings = false;

    String patternQuote(String str) {
        return str.replaceAll("([\\\\\\[\\].^$?*+{}()|])", "\\\\$1");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1894().patternQuote(str));
    }
}
