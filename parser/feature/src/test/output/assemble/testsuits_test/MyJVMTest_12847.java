import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_12847 {

    void bug6371431() throws Exception {
        String encoding = "Cp33722";
        Charset charset = Charset.forName(encoding);
        CharsetDecoder converter = charset.newDecoder();
        converter = converter.onMalformedInput(CodingErrorAction.REPORT);
        converter = converter.onUnmappableCharacter(CodingErrorAction.REPORT);
        int errors = 0;
        for (int b = 0xa0; b < 0x100; b++) {
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
        new MyJVMTest_12847().bug6371431();
    }
}
