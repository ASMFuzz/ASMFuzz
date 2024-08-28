import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16144 {

    void bug6371619() throws Exception {
        String encoding = "Cp964";
        Charset charset = Charset.forName(encoding);
        CharsetDecoder converter = charset.newDecoder();
        converter = converter.onMalformedInput(CodingErrorAction.REPORT);
        converter = converter.onUnmappableCharacter(CodingErrorAction.REPORT);
        int errors = 0;
        for (int b = 0x80; b < 0x100; b++) if (!(b == 0x8e || (b >= 0x80 && b <= 0x8d) || (b >= 0x90 && b <= 0x9f))) {
            ByteBuffer in = ByteBuffer.wrap(new byte[] { (byte) b });
            try {
                CharBuffer out = converter.decode(in);
                if (out.length() == 0) {
                    errors++;
                }
            } catch (CharacterCodingException e) {
            }
        }
        if (errors > 0)
            throw new Exception("Charset " + charset + ": " + errors + " errors");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16144().bug6371619();
    }
}
