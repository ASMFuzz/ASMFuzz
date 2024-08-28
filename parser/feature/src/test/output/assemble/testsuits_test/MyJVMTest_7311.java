public class MyJVMTest_7311 {

    static String kind = "TM@*goUc@S";

    static String found = "pE`]|P>M||";

    static String expect = " 41$*(3{FS";

    static int errors = 0;

    String checkEqual(String kind, String found, String expect) {
        if (!found.equals(expect)) {
            System.err.println("error: unexpected value for " + kind);
            System.err.println("expect: >>" + expect + "<<");
            System.err.println(" found: >>" + found + "<<");
            errors++;
        }
        return found;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7311().checkEqual(kind, found, expect);
    }
}
