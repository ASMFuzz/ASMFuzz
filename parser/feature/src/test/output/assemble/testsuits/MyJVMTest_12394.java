public class MyJVMTest_12394 {

    static boolean ignoreEncodingErrors = false;

    static int i = 0;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "import java.util.*;\n" + "public class Test {\n" + "    void foobar() {\n" + "        Iterator<Number> itr = null;\n" + "        String str = itr.next();\n" + "        FooBar fooBar = FooBar.foobar();\n" + "    }\n" + "}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12394().getCharContent(ignoreEncodingErrors));
    }
}
