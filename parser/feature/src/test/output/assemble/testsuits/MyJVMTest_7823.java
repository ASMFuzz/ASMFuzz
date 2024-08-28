import java.io.*;

public class MyJVMTest_7823 {

    static String encoding = "pS\\sp0w/Bq";

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
        new MyJVMTest_7823().tryToEncode(encoding);
    }
}
