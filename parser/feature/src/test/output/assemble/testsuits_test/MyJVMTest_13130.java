public class MyJVMTest_13130 {

    static String[] args = { "E01E]hWL6z", "j+\"ErY_-c%", "0mdOo|!]`g", "J:-<dzC9K[", "BAQ>sS(1tB", "3PKr|=GzHF", "4TV{BH.H(g", "fP&ZuRiy9,", "+@M_m\"ljD]", "l+y/ G(2@g" };

    static boolean separateServerThread = false;

    static String tmAlgorithm = "h~:2F(>eV5";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13130().parseArguments(args);
    }
}
