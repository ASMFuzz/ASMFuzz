public class MyJVMTest_3083 {

    static boolean ignoreEncodingErrors = true;

    static int i = 0;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "import java.util.*;\n" + "public class Test {\n" + "    void foobar() {\n" + "        Iterator<Number> itr = null;\n" + "        String str = itr.next();\n" + "        FooBar fooBar = FooBar.foobar();\n" + "    }\n" + "}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3083().getCharContent(ignoreEncodingErrors));
    }
}
