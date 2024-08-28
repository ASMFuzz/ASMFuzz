import java.security.*;
import java.io.*;
import java.nio.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;

public class MyJVMTest_9752 {

    static String label = "KYjfPjyv\\?";

    static String[] strs = { "w\\D[g$a/p:", "%|R.;1qul!", "Vnb7{|20qk", "];MiC](X}\\", "?KX+P8%BN4", "4d0I}*`cTt", "#;$s~Y%Suv", "ImPTgwfRio", "WO3?A0A)X5", "z4G_jdn?EI" };

    String[] printStrings(String label, String[] strs) {
        System.out.println(label);
        for (int i = 0; i < strs.length; i++) {
            System.out.println("    " + strs[i]);
        }
        return strs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9752().printStrings(label, strs);
    }
}
