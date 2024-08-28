import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_1052 {

    static String alg = "5,?p>~\\uXX";

    static byte[] plaintext = { -9, -39, 96, -55, -81, 62, -110, 56, -123, 59 };

    static char[] password = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '|', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '0', Character.MIN_VALUE };

    static String pParam1 = "_P87-/XD+<";

    static double pParam2 = Double.POSITIVE_INFINITY;

    static String pParam3 = "]BWdeAk\\EE";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    Mac runTest(String alg, byte[] plaintext, char[] password, Provider p) throws Exception {
        Mac mac = Mac.getInstance(alg, p);
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
        SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBE", p);
        SecretKey key = keyFac.generateSecret(pbeKeySpec);
        System.out.println("testing parameters with 4-byte salt...");
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(new byte[4], 1024);
        try {
            mac.init(key, pbeParamSpec);
            throw new Exception("ERROR: should throw IAPE for short salts");
        } catch (InvalidAlgorithmParameterException iape) {
        }
        System.out.println("testing parameters with 8-byte salt...");
        pbeParamSpec = new PBEParameterSpec(new byte[8], 1024);
        mac.init(key, pbeParamSpec);
        mac.doFinal(plaintext);
        System.out.println("testing parameters with 20-byte salt...");
        pbeParamSpec = new PBEParameterSpec(new byte[20], 1024);
        mac.init(key, pbeParamSpec);
        mac.doFinal(plaintext);
        System.out.println("testing parameters with 30-byte salt...");
        pbeParamSpec = new PBEParameterSpec(new byte[30], 1024);
        mac.init(key, pbeParamSpec);
        mac.doFinal(plaintext);
        System.out.println("passed: " + alg);
        return mac;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1052().runTest(alg, plaintext, password, p);
    }
}
