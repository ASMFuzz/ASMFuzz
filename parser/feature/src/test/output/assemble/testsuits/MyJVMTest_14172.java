public class MyJVMTest_14172 {

    static String arg = "l4t:Tw73*m";

    boolean isSnippetArg(String arg) {
        return arg.startsWith("snippetsPattern:");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14172().isSnippetArg(arg));
    }
}
