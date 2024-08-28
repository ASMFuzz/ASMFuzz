public class MyJVMTest_13676 {

    static String s = "*-}!cHc>'s";

    static String nl = System.getProperty("line.separator");

    String normalizeNewlines(String s) {
        return (nl.equals("\n") ? s : s.replace(nl, "\n"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13676().normalizeNewlines(s));
    }
}
