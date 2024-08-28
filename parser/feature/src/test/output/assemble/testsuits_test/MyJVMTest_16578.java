public class MyJVMTest_16578 {

    static boolean ignoreEncodingErrors = true;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "public class Test<TTT> { public void test() {TTT ttt;}}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16578().getCharContent(ignoreEncodingErrors));
    }
}
