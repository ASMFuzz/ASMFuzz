import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_11055 {

    static Charset ascii = Charset.forName("US-ASCII");

    void oswNegative() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos, ascii.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT));
        try {
            osw.write("\u00A0\u00A1");
        } catch (UnmappableCharacterException x) {
            return;
        }
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11055().oswNegative();
    }
}
