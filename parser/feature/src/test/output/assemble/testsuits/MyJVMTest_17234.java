import java.beans.ExceptionListener;

public class MyJVMTest_17234 {

    static int length = -1658880265;

    static String encoding = "=tcd:%{Ph|";

    String createString(int length) {
        StringBuilder sb = new StringBuilder(length);
        while (0 < length--) sb.append((char) length);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17234().createString(length));
    }
}
