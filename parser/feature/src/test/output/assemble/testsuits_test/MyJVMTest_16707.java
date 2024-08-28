import java.io.*;

public class MyJVMTest_16707 {

    static String testPath = "V>ULxh#V$j";

    void copyClassFile() throws Exception {
        FileInputStream fis = new FileInputStream(testPath + "Hello.class");
        FileOutputStream fos = new FileOutputStream("a#b/Hello.class");
        int bytesRead;
        byte[] buf = new byte[410];
        do {
            bytesRead = fis.read(buf);
            if (bytesRead > 0)
                fos.write(buf, 0, bytesRead);
        } while (bytesRead != -1);
        fis.close();
        fos.flush();
        fos.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16707().copyClassFile();
    }
}
