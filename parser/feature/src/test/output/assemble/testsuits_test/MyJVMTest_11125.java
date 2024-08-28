public class MyJVMTest_11125 {

    static String str = "^oeY//GIb!";

    static boolean laxLineEndings = false;

    String patternQuote(String str) {
        return str.replaceAll("([\\\\\\[\\].^$?*+{}()|])", "\\\\$1");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11125().patternQuote(str));
    }
}
