import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_740 {

    static String canonicalName = "TIDCm\\D+?U";

    static String[] aliasNames = { "hBu7ul8=$z", "~b?@yi32H/", "\"R</v;rB!#", "%jt^y3E~&$", "0g\"?m)UhT>", "$H XYwNWmx", "9;GhE@ S-o", "^Oui*ERl{1", "D,\"LDe*xJc", "Jy= bO(j]E" };

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
        new MyJVMTest_740().aliasCheck(canonicalName, aliasNames);
    }
}
