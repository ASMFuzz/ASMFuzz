public class MyJVMTest_17881 {

    static boolean ignoreEncodingErrors = false;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test<S> { <T extends S & Runnable> void test(){}}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17881().getCharContent(ignoreEncodingErrors));
    }
}
