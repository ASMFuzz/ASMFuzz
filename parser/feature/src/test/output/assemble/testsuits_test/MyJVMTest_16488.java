public class MyJVMTest_16488 {

    static String[] target = { "z19}'{Rfs@", "Xp;etx~wJ/", "[M\"7=6<_Eo", "[Fpgc9Qjg+", "J1,7?d,\"T%", "k!]hEE<]\\0", "sF]pIR0_{_", "n[\\^Wf7Q^9", "XJX2pHZf/c", "{L{EVl?TS8" };

    static String contextVersion = "=C&Jl7$=hK";

    static String[] serverEnabledProtocols = {"aTQwkX&A@d","Q>PPv:h^O+","e{j4.!*L!}","CY?)cI`YY*","#':g[/:cI(","%%G6[(%!v)","M_Qg\\I&:/}","h4X0doM:sU","6VvJN>/Ue*","`w HG>:g6)"};

    static String[] clientEnabledProtocols = {"lQGnp*<,k-","cSVg{:`t-,","5!XE>+fEfX"," (B]&[&LWt","!z0f]70PxZ","]ZE3RU'B3t","o&[\"*ZCI7t","V^gYks;'3=","]i/aOti^ A","ZVn7z.|aYn"};

    boolean checkCipherSuites(String[] target) {
        boolean success = true;
        if (target.length == 0) {
            System.out.println("\tError: No cipher suites");
            success = false;
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16488().checkCipherSuites(target));
    }
}
