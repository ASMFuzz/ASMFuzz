public class MyJVMTest_3790 {

    static String[] args = { "jrHR,2$WqI", "@?Ji{l]7Mo", "[IqED'&Pib", "5-1;Bw@,'B", "l}<<A$2fwi", "E;m7a&5BN:", "LTmG&:|e5l", "(sw^b'B~$f", "oa*a`@a-(u", "C,?oMWp?;0" };

    static boolean separateServerThread = false;

    static String tmAlgorithm = "$dVa}]?B\"{";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3790().parseArguments(args);
    }
}
