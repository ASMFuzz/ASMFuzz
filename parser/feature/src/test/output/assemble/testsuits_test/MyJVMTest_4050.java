import java.security.*;
import java.util.*;

public class MyJVMTest_4050 {

    void testDefaultEgd() throws Exception {
        String s = Security.getProperty("securerandom.source");
        System.out.println("Testing:  default EGD: " + s);
        if (!s.equals("file:/dev/random")) {
            throw new Exception("Default is not 'file:/dev/random'");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4050().testDefaultEgd();
    }
}
