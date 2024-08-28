import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class MyJVMTest_9232 {

    static char[] password = null;

    String getAlgorithm() {
        return "PBE";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9232().getAlgorithm());
    }
}
