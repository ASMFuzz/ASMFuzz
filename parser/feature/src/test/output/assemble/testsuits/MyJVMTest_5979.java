import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_5979 {

    static String a = "Iog@Y#w^;o";

    static String b = "R]Sj,'EdFS";

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
        new MyJVMTest_5979().assertStringEquals(a, b);
    }
}
