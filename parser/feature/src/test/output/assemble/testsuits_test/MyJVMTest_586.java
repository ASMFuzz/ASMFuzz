import java.security.*;
import java.io.*;
import java.nio.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;

public class MyJVMTest_586 {

    static String label = "0$.Mv/e7 &";

    static String[] strs = { "hRX@14tC\"2", "nrCX[p\"6G'", "$]`[e~9K;<", "!f:8\\,ui9)", "-n+P9<C\\Ks", "gcYA@zEP/&", ">bvp<naN-W", "75z$hYxp,<", "03;7VuzkWt", "(Jz}-hL$Wd" };

    String[] printStrings(String label, String[] strs) {
        System.out.println(label);
        for (int i = 0; i < strs.length; i++) {
            System.out.println("    " + strs[i]);
        }
        return strs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_586().printStrings(label, strs);
    }
}
