public class MyJVMTest_16837 {

    static String kind = "C!t#}o8ZZt";

    static String found = "z5:BDj+MYw";

    static String expect = "T@Q<>r9l\"U";

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
        new MyJVMTest_16837().checkEqual(kind, found, expect);
    }
}
