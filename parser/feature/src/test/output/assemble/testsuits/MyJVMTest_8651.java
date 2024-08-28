import java.nio.charset.*;

public class MyJVMTest_8651 {

    static String canonicalName = "N=UKCO (X8";

    static String[] aliasNames = { "^fSmjjgqV7", "U4B^{WKjM$", ",2g21je/.d", "Hy=.%{.G\" ", "]?bL}I?'n}", "_~Xi H*3)2", ".bCvK#gIiJ", "mFw(JU:0pa", "0{*whlrEdM", "lmYfgt{)g'" };

    String aliasCheck(String canonicalName, String[] aliasNames) throws Exception {
        for (int k = 0; k < aliasNames.length; k++) {
            Charset cs = Charset.forName(aliasNames[k]);
            if (!cs.name().equals(canonicalName)) {
                throw new Exception("Unexpected Canonical name " + canonicalName);
            }
        }
        return canonicalName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8651().aliasCheck(canonicalName, aliasNames);
    }
}
