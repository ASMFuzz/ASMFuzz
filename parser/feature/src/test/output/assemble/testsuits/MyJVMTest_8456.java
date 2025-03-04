import java.security.*;
import java.security.interfaces.*;
import javax.crypto.*;

public class MyJVMTest_8456 {

    void run() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH", "SunJCE");
        KeyPair keyA = keyGen.generateKeyPair();
        KeyPair keyB = keyGen.generateKeyPair();
        KeyAgreement bobAlice = KeyAgreement.getInstance("DH", "SunJCE");
        bobAlice.init(keyB.getPrivate());
        bobAlice.doPhase(keyA.getPublic(), true);
        byte[] keyMaterial = bobAlice.generateSecret();
        bobAlice.doPhase(keyA.getPublic(), true);
        SecretKey skey = bobAlice.generateSecret("AES");
        byte[] keyVal = skey.getEncoded();
        System.out.println("Generated " + keyVal.length * 8 + "-bit AES key");
        for (int i = 0; i < keyVal.length; i++) {
            if (keyVal[i] != keyMaterial[i]) {
                throw new Exception("Error: key value comparison failed!");
            }
        }
        System.out.println("Test Passed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8456().run();
    }
}
