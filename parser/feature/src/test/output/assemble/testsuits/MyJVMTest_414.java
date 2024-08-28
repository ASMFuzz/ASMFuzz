import java.io.*;

public class MyJVMTest_414 {

    static String str = "T+xBVv)_w)";

    static LSI cisi = null;

    static LSI iisi = null;

    char[] checkIdentifier(String str) throws Exception {
        char[] chars = str.toCharArray();
        if (!Character.isJavaIdentifierStart(chars[0])) {
            throw new IllegalArgumentException(str + ": bad identifier start character: '" + chars[0] + "'");
        }
        for (char ch : chars) {
            if (!Character.isJavaIdentifierPart(ch)) {
                throw new IllegalArgumentException(str + ": bad identifier character: '" + ch + "'");
            }
        }
        return chars;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_414().checkIdentifier(str);
    }
}
