public class MyJVMTest_14452 {

    static String found = "pY!/dO*reN";

    static String expect = "di(L\"A]|&/";

    void error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
    }

    static boolean print = false;

    static String PREFIX = "#<";

    static String SUFFIX = "#>";

    static int errors = 0;

    static String source = "class Test {\n" + "    int i;\n" + "    void m() {\n" + "        #S\n" + "    }\n" + "}";

    String checkEqual(String found, String expect) {
        boolean match = (found == null) ? (expect == null) : expect.equals(found.replaceAll("^\\Q" + PREFIX + "\\E\\s*", "").replaceAll("\\s*\\Q" + SUFFIX + "\\E$", "").replaceAll("\\s+", " "));
        if (!match)
            error("Mismatch: expected: " + expect + " found: " + found);
        return found;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14452().checkEqual(found, expect);
    }
}
