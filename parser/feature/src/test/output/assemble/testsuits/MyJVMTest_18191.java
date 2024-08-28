import java.util.*;
import java.nio.*;
import java.awt.color.ColorSpace;

public class MyJVMTest_18191 {

    static String signature = "h22G=!UTVP";

    static byte[][] profiles = {{-45,30,-102,86,3,-120,26,36,67,68},{100,89,47,17,122,-50,59,113,84,-99}};

    static Hashtable<Integer, byte[]>[] tags = new Hashtable<Integer,byte[]>[]();

    static int[] cspaces = { ColorSpace.CS_sRGB, ColorSpace.CS_PYCC, ColorSpace.CS_LINEAR_RGB, ColorSpace.CS_CIEXYZ, ColorSpace.CS_GRAY };

    boolean isKodakExtention(String signature) {
        return signature.matches("K\\d\\d\\d");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18191().isKodakExtention(signature));
    }
}
