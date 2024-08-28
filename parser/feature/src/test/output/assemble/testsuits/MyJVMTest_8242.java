public class MyJVMTest_8242 {

    static String[] target = { "D'cUp=6p2#", "b-*rKb3'Dz", "Y}td,%@|h!", "%\"M+KP3>=+", "6%E]P\\ruHN", "$dN:13<k i", "WO!O~`#}m3", "tbOBNo&<0%", "PTxe#,OJy ", "0<VmFcvS\"A" };

    static String contextVersion = "6<1*&gY4W3";

    static String[] serverEnabledProtocols = {"EUD}t[v)Wf",":\\)?w7ug}l","GFK*?e8i/0","%XV`.\"ud.G","CTZd~/Mss?","2A,vi8NKEh","3<x$9\\C<W.","c^wr)0}HE/","QMyWK\\9fH|","55XB?w#J>6"};

    static String[] clientEnabledProtocols = {"1v6]:0!B\"p","0l2;[*'i:S","@-Ga6$TTi]","Tzq?Qj^A6J","X*-b{?qR9q","A=c'~#_M\\V","tOq~,?FN$U","iCZw8z ZKJ","O\":q~-i=Tk","/yD3j#!_9/"};

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
        System.out.println(new MyJVMTest_8242().checkCipherSuites(target));
    }
}
