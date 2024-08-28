import java.security.*;
import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_18098 {

    static int value = 0;

    static int padding = 5;

    int hexPrint(int value, int padding) {
        String hexString = new String("0123456789ABCDEF");
        for (int i = (padding - 1); i >= 0; i--) {
            System.out.print(hexString.charAt((value >> (i * 4)) & 0xF));
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18098().hexPrint(value, padding);
    }
}
