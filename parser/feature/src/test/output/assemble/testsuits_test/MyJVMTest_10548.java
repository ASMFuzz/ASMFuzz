public class MyJVMTest_10548 {

    static String msg = "b^iGrHv#*B";

    static boolean print = false;

    static int errors = 0;

    static String source = "class Test {\n" + "    int i;\n" + "    void m() {\n" + "        #S\n" + "    }\n" + "}";

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10548().error(msg);
    }
}
