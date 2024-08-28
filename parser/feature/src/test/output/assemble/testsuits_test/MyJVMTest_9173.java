public class MyJVMTest_9173 {

    static String[] target = { "RH#'[b@Gp\\", "M~1urF$W28", "hTW\\m\\_gk>", "jz'l@,:iuu", "D+>3V^WMYm", "iHj )(*$@1", "$hyH%\"-Ar0", "zR<Cem5Itp", "CfYgn(o%Lr", "3w8.?l=!;-" };

    static String contextVersion = "4k0=2r7/Zw";

    static String[] enabledProtocols = {"{t$>i,a691","H7\\Q- 6#{6","jP'f;X`SKH","VpCQ0Ac_mb","i%mLHcNT,/","R5W1-8x&.u"," VKCu/ d\\<","@Y[b/vfp}r","KP<s;#gZH(","5)8&nESZ 1"};

    boolean checkCipherSuites(String[] target) {
        boolean success = true;
        if (target.length == 0) {
            System.out.println("\tError: No cipher suites");
            success = false;
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9173().checkCipherSuites(target));
    }
}
