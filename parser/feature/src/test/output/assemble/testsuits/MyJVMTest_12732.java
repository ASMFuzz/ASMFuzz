public class MyJVMTest_12732 {

    static boolean ignoreEncodingErrors = true;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "public enum Test { ABC, DEF; }";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12732().getCharContent(ignoreEncodingErrors));
    }
}
