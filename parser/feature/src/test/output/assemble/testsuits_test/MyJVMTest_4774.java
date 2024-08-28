public class MyJVMTest_4774 {

    static String arg = "4:m<}g;S3Q";

    boolean isSnippetArg(String arg) {
        return arg.startsWith("snippetsPattern:");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4774().isSnippetArg(arg));
    }
}
