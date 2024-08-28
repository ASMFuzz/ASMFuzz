import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_15434 {

    static String a = "{NfG_NW:y7";

    static String b = ";`]?rnbd\\D";

    String assertStringEquals(String a, String b) {
        a = a.replaceAll(" ", "");
        b = b.replaceAll(" ", "");
        if (!a.equals(b)) {
            throw new RuntimeException("Not equal: " + a + " AND " + b);
        }
        System.err.print(".");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15434().assertStringEquals(a, b);
    }
}
