public class MyJVMTest_9347 {

    static String[] target = { "8O-8-~i,EW", "/N]\\E|&KDz", "S${0^b0PkJ", "`)aAh0`2Wz", "8H8vXuf|;B", "#-K9J(oc/2", "'5o8\"RGFJt", ">]ef9Nb+~;", "y5O)0v9b&h", "Yajl|Kfy\"P" };

    static String contextVersion = "l@ h;GAt(j";

    static String[] enabledProtocols = {"4vh[('P'y%","J`]=5CG>YD","+Ym0?UskA\\","84)j\"*+$zg","mz$)#*xny$","{E ATrJ!`[","Im_h?aY0PR","S)YRrgPW|r","2w[DMFq!Jj","vJ?kctT<Do"};

    boolean checkCipherSuites(String[] target) {
        boolean success = true;
        if (target.length == 0) {
            System.out.println("\t\t\t*** Error: No cipher suites");
            success = false;
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9347().checkCipherSuites(target));
    }
}
