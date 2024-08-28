import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_9918 {

    static String canonicalName = "4v1,LT7Fc?";

    static String[] aliasNames = { "{3[;+A0{Yr", ").$4_>|\"S.", "w`&v* V;pR", "L{eStTS)]u", "<6{J/L2M>;", "3ZI[E[YhBM", "Y\"%NXJsx$2", "&2|bL'ccEP", "h]<PiJHi'<", "u'<,SL_RtP" };

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
        new MyJVMTest_9918().aliasCheck(canonicalName, aliasNames);
    }
}
