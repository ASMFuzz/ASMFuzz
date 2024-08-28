import javax.net.ssl.*;

public class MyJVMTest_6017 {

    static String[] args = { "Ms1R]$$FlU", "NijKPo;2VW", "=|x+@3Ez&o", "Y=]>IBY7s0", "BX\\:}}`/#&", "ut7/u}(.dX", "&zWq'R&9cT", "{*&64j7U=9", "De_}`7>es`", "R~`zb\\X}#7" };

    static String tmAlgorithm = "3%4-/0n?@x";

    static String tlsProtocol = "^K ,2,7WUg";

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        tlsProtocol = args[1];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6017().parseArguments(args);
    }
}
