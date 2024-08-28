import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_6142 {

    static byte[] bs = { 92, -122, 53, 63, 111, 49, -17, 64, 85, 1 };

    String hex(byte[] bs) {
        StringBuffer sb = new StringBuffer(bs.length * 2);
        for (byte b : bs) {
            char c = (char) ((b + 256) % 256);
            if (c / 16 < 10)
                sb.append((char) (c / 16 + '0'));
            else
                sb.append((char) (c / 16 - 10 + 'a'));
            if (c % 16 < 10)
                sb.append((char) (c % 16 + '0'));
            else
                sb.append((char) (c % 16 - 10 + 'a'));
        }
        return new String(sb);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6142().hex(bs));
    }
}
