import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_10123 {

    void bug6371422() throws Exception {
        String[] charsets = { "Cp949", "Cp949C" };
        for (int n = 0; n < charsets.length; n++) {
            String charset = charsets[n];
            CharsetEncoder converter = Charset.forName(charset).newEncoder();
            converter = converter.onMalformedInput(CodingErrorAction.REPORT);
            converter = converter.onUnmappableCharacter(CodingErrorAction.REPORT);
            int errors = 0;
            for (int i = 1; i < 0x1ffff; i++) {
                if (i >= 0x1100 && i <= 0x11f9)
                    continue;
                char[] in = (i < 0x10000 ? new char[] { (char) i } : new char[] { (char) (0xd800 + ((i - 0x10000) >> 10)), (char) (0xdc00 + ((i - 0x10000) & 0x3ff)) });
                try {
                    ByteBuffer out = converter.encode(CharBuffer.wrap(in));
                    if (out.remaining() == 0 || (out.remaining() == 1 && out.get(0) == 0x00)) {
                        errors++;
                    }
                } catch (CharacterCodingException e) {
                }
            }
            if (errors > 0)
                throw new Exception("Charset " + charset + ": " + errors + " errors");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10123().bug6371422();
    }
}
