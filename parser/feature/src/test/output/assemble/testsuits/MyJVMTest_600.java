import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_600 {

    static Charset ascii = Charset.forName("US-ASCII");

    void oswPositive() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos, ascii.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT));
        osw.write("hi");
        osw.close();
        if (!ascii.decode(ByteBuffer.wrap(bos.toByteArray())).toString().equals("hi"))
            throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_600().oswPositive();
    }
}
