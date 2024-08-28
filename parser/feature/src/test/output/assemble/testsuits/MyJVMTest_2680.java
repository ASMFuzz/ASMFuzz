import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_2680 {

    static Charset ascii = Charset.forName("US-ASCII");

    void isrNegative() throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(new byte[] { (byte) 0xff, (byte) 0xff });
        InputStreamReader isr = new InputStreamReader(bis, ascii.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT));
        BufferedReader br = new BufferedReader(isr);
        try {
            br.readLine();
        } catch (MalformedInputException x) {
            return;
        }
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2680().isrNegative();
    }
}
