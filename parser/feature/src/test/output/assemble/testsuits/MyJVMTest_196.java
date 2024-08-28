public class MyJVMTest_196 {

    static String[] target = { "l1g|rin|nP", "zNFISrx0?*", "@LE=QHOx4_", "yrqu]6lLnt", "iT$rqF5<*.", "fV10Rr[9YU", "|\"/sSZKmg?", "HcgF_B_YMt", "R%CBoevs`t", "CR-Ddm/zZb" };

    static String contextVersion = "CwPxp7FH1l";

    static String[] enabledProtocols = {"Hy`EBVxo6.","FST\\wG!ksN","om!Ofe\"fqA","o\"ojY6&:}$","zaOxqg?t01","ZoILi1U7R/","V_KAsdo}!%","]E5\\(M]V4`","Ell5_p2?E0","L;IGbk[74i"};

    boolean checkCipherSuites(String[] target) {
        boolean success = true;
        if (target.length == 0) {
            System.out.println("\t\t\t*** Error: No cipher suites");
            success = false;
        }
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_196().checkCipherSuites(target));
    }
}
