import java.io.*;
import java.net.*;

public class MyJVMTest_5046 {

    static String str = "MX4ht}jG}\"";

    static String correctEncoding = "gB:Uyzi.[[";

    String getHexBytes(String s) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            int b1 = (a >> 8) & 0xff;
            int b2 = (byte) a;
            int b11 = (b1 >> 4) & 0x0f;
            int b12 = b1 & 0x0f;
            int b21 = (b2 >> 4) & 0x0f;
            int b22 = b2 & 0x0f;
            sb.append(Integer.toHexString(b11));
            sb.append(Integer.toHexString(b12));
            sb.append(Integer.toHexString(b21));
            sb.append(Integer.toHexString(b22));
            sb.append(' ');
        }
        return sb.toString();
    }

    String test(String str, String correctEncoding) throws Exception {
        System.out.println("Unicode bytes of test string are: " + getHexBytes(str));
        String encoded = URLEncoder.encode(str, "UTF-8");
        System.out.println("URLEncoding is: " + encoded);
        if (encoded.equals(correctEncoding))
            System.out.println("The encoding is correct!");
        else {
            throw new Exception("The encoding is incorrect!" + " It should be " + correctEncoding);
        }
        String decoded = URLDecoder.decode(encoded, "UTF-8");
        System.out.println("Unicode bytes for URLDecoding are: " + getHexBytes(decoded));
        if (str.equals(decoded))
            System.out.println("The decoding is correct");
        else {
            throw new Exception("The decoded is not equal to the original");
        }
        System.out.println("---");
        return encoded;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5046().test(str, correctEncoding);
    }
}
