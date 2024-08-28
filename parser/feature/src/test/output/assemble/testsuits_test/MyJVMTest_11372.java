import java.io.*;
import java.security.*;

public class MyJVMTest_11372 {

    static String algorithm = "|(0Ik<9&Y_";

    ObjectInputStream deserializeTigerKey(String algorithm) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("test.src", ".") + File.separator + algorithm + ".1.5.key"));
        ois.readObject();
        ois.close();
        return ois;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11372().deserializeTigerKey(algorithm);
    }
}
