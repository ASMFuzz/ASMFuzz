public class MyJVMTest_3402 {

    static boolean ignoreEncodingErrors = false;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "public enum Test { ABC, DEF; }";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3402().getCharContent(ignoreEncodingErrors));
    }
}
