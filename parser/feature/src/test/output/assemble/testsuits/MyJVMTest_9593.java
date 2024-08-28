import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_9593 {

    static byte[] encoded = { 46, -69, -33, 0, -26, 12, -106, -113, 94, -7 };

    static char[] decoded = { Character.MIN_VALUE, Character.MAX_VALUE, 'u', 'f', '7', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'G', Character.MAX_VALUE };

    static String label = "1XIUMBb}\"H";

    static String encodingName = "ISO2022CN";

    boolean decodeTest(byte[] encoded, char[] decoded, String label) {
        boolean retval = true;
        int i = 0;
        try {
            ByteArrayInputStream in;
            InputStreamReader reader;
            in = new ByteArrayInputStream(encoded);
            reader = new InputStreamReader(in, encodingName);
            for (i = 0; i < decoded.length; i++) {
                int c = reader.read();
                if (c != decoded[i]) {
                    System.err.print(label + ": read failed, char " + i);
                    System.err.print(" ... expected 0x" + Integer.toHexString(decoded[i]));
                    if (c == -1)
                        System.err.println(", got EOF");
                    else
                        System.err.println(", got 0x" + Integer.toHexString(c));
                    retval = false;
                    if (c == -1)
                        return retval;
                }
            }
            int testChar;
            if ((testChar = reader.read()) != -1) {
                System.err.println(label + ": read failed, no EOF");
                System.err.println("testChar is " + Integer.toHexString((int) testChar));
                return false;
            }
            String decodedString = new String(encoded, "ISO2022CN");
            for (i = 0; i < decodedString.length(); i++) {
                if (decodedString.charAt(i) != decoded[i])
                    System.err.println(label + ": read failed, char " + i);
            }
            CharsetDecoder dec = Charset.forName("ISO2022CN").newDecoder().onUnmappableCharacter(CodingErrorAction.REPLACE).onMalformedInput(CodingErrorAction.REPLACE);
            ByteBuffer bb = ByteBuffer.allocateDirect(encoded.length).put(encoded);
            bb.flip();
            CharBuffer cb = ByteBuffer.allocateDirect(2 * encoded.length * (int) dec.maxCharsPerByte()).asCharBuffer();
            if (bb.hasArray() || cb.hasArray()) {
                System.err.println(label + ": directBuffer failed, ");
                return false;
            }
            if (!dec.decode(bb, cb, true).isUnderflow()) {
                System.err.println(label + ": decoder's decode() failed!");
                return false;
            }
            cb.flip();
            for (i = 0; i < cb.limit(); i++) {
                if (cb.get() != decoded[i])
                    System.err.println(label + ": decoder failed, char " + i);
            }
        } catch (Exception e) {
            System.err.println(label + ": failed " + "(i = " + i + "), " + e.getClass().getName() + ", " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return retval;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9593().decodeTest(encoded, decoded, label));
    }
}
