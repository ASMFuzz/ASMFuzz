import java.io.*;
import java.net.*;
import java.util.Arrays;

public class MyJVMTest_1740 {

    static String encoding = "S5aUU\" >9x";

    static String XML_HEADER = "<?xml";

    byte[] toBOMBytes(String encoding) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        switch(encoding) {
            case "UTF-8":
                bos.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                break;
            case "UTF-16BE":
                bos.write(new byte[] { (byte) 0xFE, (byte) 0xFF });
                break;
            case "UTF-16LE":
                bos.write(new byte[] { (byte) 0xFF, (byte) 0xFE });
                break;
            case "UTF-32BE":
                bos.write(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0xFE, (byte) 0xFF });
                break;
            case "UTF-32LE":
                bos.write(new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0x00, (byte) 0x00 });
        }
        bos.write(XML_HEADER.getBytes(encoding));
        return bos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1740().toBOMBytes(encoding)));
    }
}
