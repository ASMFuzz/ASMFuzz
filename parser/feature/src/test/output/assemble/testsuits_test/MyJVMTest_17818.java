public class MyJVMTest_17818 {

    static String[] target = { "n\"oxE5 Y-w", "0\\z7@#Q:L]", "~c;:OS{uk<", "IQaDF~FFOZ", "[m(3p]oE^`", "Y^YczewcG3", "i\"%joc)J\\Q", "7l'-78nqQU", "~W;'LXJ*bz", "`t}3v3V3-O" };

    static String contextVersion = "^+Lz{?){G4";

    static String[] serverEnabledProtocols = {"g8Nq6jAcf4","vf7INZRM2'","(%bFc@HpD0","T'/s(;y! c","!xcSg_.;86","J:*vvZscLk","qF\\)tYpImx","V>N!-4j%g/","5?/WI~P;3L","|`Gb[l|%iS"};

    static String[] clientEnabledProtocols = {"?N[MtJ]`r;","@JP3'$Bfo$","b<|1=TQzOB","nEL$p,(SZ$","8 @eg`|5S@",";{-K{((? ~","*2P }S<p-w","Ts(W}'Z=o1","r5/lvE*A6C","R\\y\\*IKYOI"};

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
        System.out.println(new MyJVMTest_17818().checkCipherSuites(target));
    }
}
