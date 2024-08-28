public class MyJVMTest_7060 {

    static boolean ignoreEncodingErrors = false;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "public class Test<TTT> { public void test() {TTT ttt;}}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7060().getCharContent(ignoreEncodingErrors));
    }
}
