import java.beans.ExceptionListener;

public class MyJVMTest_7682 {

    static int length = 1;

    static String encoding = "y]|Z#!/eo\\";

    String createString(int length) {
        StringBuilder sb = new StringBuilder(length);
        while (0 < length--) sb.append((char) length);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7682().createString(length));
    }
}
