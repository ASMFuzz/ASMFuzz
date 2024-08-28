public class MyJVMTest_8461 {

    static String[] target = { "wv\"~#7_}^Y", "I>6l=KUSM@", "V@nbi[ov#.", "Sq2;7VmJ*&", "=4\"4jndvhw", "v|Q>@@-~cu", "NO,3-(zuWY", "zn+Ho~EZ/G", "fLxOF;%(V%", "twKT#  .N`" };

    static String contextVersion = "OrN$v)o:#1";

    static String[] enabledProtocols = {"HXjiu<O1OM","Sv!sY+,#L:",":bVhZ(q;B;","FNNT[6hSE#","nJR!OW(,oX",",;.,^F>9^T","&R%)?@K#,`","dP@jQW+/T3","H/COYT[!h:","le)1[&~|8a"};

    boolean checkCipherSuites(String[] target) {
        boolean success = true;
        if (target.length == 0) {
            System.out.println("\t\t\t*** Error: No cipher suites");
            success = false;
        }
        System.out.println("\t\t\t--> Cipher check passed!!");
        return success;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8461().checkCipherSuites(target));
    }
}
