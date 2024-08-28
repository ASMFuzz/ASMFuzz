import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_15611 {

    static byte[] bs = { 75, -83, -55, -74, -21, -96, 92, -78, 102, 25 };

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
        System.out.println(new MyJVMTest_15611().hex(bs));
    }
}
