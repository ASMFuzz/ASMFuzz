import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class MyJVMTest_5573 {

    static char[] password = null;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5573().getFormat());
    }
}
