import java.io.*;
import java.security.*;

public class MyJVMTest_13450 {

    static String algorithm = "w+K4rk))u/";

    ObjectInputStream deserializeKey(String algorithm) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("test.src", ".") + File.separator + algorithm + ".pre.1.5.key"));
        ois.readObject();
        ois.close();
        return ois;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13450().deserializeKey(algorithm);
    }
}
