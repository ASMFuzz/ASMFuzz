public class MyJVMTest_8305 {

    static boolean ignoreEncodingErrors = true;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test<S> { <T extends S & Runnable> void test(){}}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8305().getCharContent(ignoreEncodingErrors));
    }
}
