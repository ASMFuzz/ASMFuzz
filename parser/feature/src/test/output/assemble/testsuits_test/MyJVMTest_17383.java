import java.io.*;

public class MyJVMTest_17383 {

    static String encoding = "BrX{rv@\"6W";

    static String ENCODE_STRING = "Encode me";

    String tryToEncode(String encoding) throws Exception {
        try {
            byte[] bytes = ENCODE_STRING.getBytes(encoding);
            System.out.println("Encoding \"" + encoding + "\" recognized");
        } catch (UnsupportedEncodingException e) {
            throw new Exception("Encoding \"" + encoding + "\" NOT recognized");
        }
        return encoding;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17383().tryToEncode(encoding);
    }
}
