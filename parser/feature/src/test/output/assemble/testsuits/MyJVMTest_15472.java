import javax.net.ssl.*;

public class MyJVMTest_15472 {

    static String[] args = { "XzJ}_e+2M-", "&C8wMb`ml9", "fZ^<d]Z\"],", "7Y*3,fuZyi", "qn]`iJ0ODk", "u}V(3BcN9j", "Ri.A|ic\\Zg", "!|l&\\<]]qx", "yKAa*XpDS0", "?!c/1#P`RJ" };

    static String tmAlgorithm = "d@=m;A%2Sd";

    static String tlsProtocol = "D>Q!TQ;\\Qf";

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        tlsProtocol = args[1];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15472().parseArguments(args);
    }
}
