import java.util.*;
import java.nio.*;
import java.awt.color.ColorSpace;

public class MyJVMTest_8599 {

    static String signature = "C}Wu$sbOb$";

    static byte[][] profiles = {{-82,9,-97,12,-38,56,-60,63,-37,87},{10,22,16,111,74,57,77,-112,-108,-87}};

    static Hashtable<Integer, byte[]>[] tags = new Hashtable<Integer,byte[]>[]();

    static int[] cspaces = { ColorSpace.CS_sRGB, ColorSpace.CS_PYCC, ColorSpace.CS_LINEAR_RGB, ColorSpace.CS_CIEXYZ, ColorSpace.CS_GRAY };

    boolean isKodakExtention(String signature) {
        return signature.matches("K\\d\\d\\d");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8599().isKodakExtention(signature));
    }
}
