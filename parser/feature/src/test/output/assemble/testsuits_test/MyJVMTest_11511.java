import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import java.util.*;

public class MyJVMTest_11511 {

    static char[] spec1Param1 = { Character.MAX_VALUE, 's', Character.MIN_VALUE, Character.MIN_VALUE, '9', Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', Character.MIN_VALUE };

    static byte[] spec1Param2 = { -111, 100, 38, -102, 70, 81, -32, 75, 68, -1 };

    static int spec1Param3 = 958;

    static int spec1Param4 = 979;

    static PBEKeySpec spec1 = new PBEKeySpec(spec1Param1, spec1Param2, spec1Param3, spec1Param4);

    static char[] spec2Param1 = { Character.MIN_VALUE, 'n', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '0', '0', '1' };

    static PBEKeySpec spec2 = new PBEKeySpec(spec2Param1);

    boolean isEqual(PBEKeySpec spec1, PBEKeySpec spec2) {
        if ((spec1 == null) || (spec2 == null))
            return false;
        if (Arrays.equals(spec1.getPassword(), spec2.getPassword()) && Arrays.equals(spec1.getSalt(), spec2.getSalt()) && spec1.getIterationCount() == spec2.getIterationCount() && spec1.getKeyLength() == spec2.getKeyLength()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11511().isEqual(spec1, spec2));
    }
}
