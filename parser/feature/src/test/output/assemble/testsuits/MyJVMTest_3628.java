import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_3628 {

    static char[] input = {Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,'0','%','>','0',Character.MAX_VALUE,'D'};

    static byte[] output = {-5,119,-56,32,-26,-126,-46,-65,19,-66};

    static int LEN = 128;

    void initData() throws IOException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < LEN; i++) {
            int c = Character.MIN_SUPPLEMENTARY_CODE_POINT + 1;
            sb.append(Character.toChars(c));
        }
        input = sb.toString().toCharArray();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos, Charset.forName("UTF-8"));
        osw.write(input);
        osw.close();
        output = bos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3628().initData();
    }
}
