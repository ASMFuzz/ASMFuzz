public class MyJVMTest_4305 {

    static String s = "SocHR/F5t#";

    static String nl = System.getProperty("line.separator");

    String normalizeNewlines(String s) {
        return (nl.equals("\n") ? s : s.replace(nl, "\n"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4305().normalizeNewlines(s));
    }
}
