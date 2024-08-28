import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_17635 {

    static Charset ascii = Charset.forName("US-ASCII");

    void isrPositive() throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(new byte[] { (byte) 'h', (byte) 'i' });
        InputStreamReader isr = new InputStreamReader(bis, ascii.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT));
        BufferedReader br = new BufferedReader(isr);
        if (!br.readLine().equals("hi"))
            throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17635().isrPositive();
    }
}
