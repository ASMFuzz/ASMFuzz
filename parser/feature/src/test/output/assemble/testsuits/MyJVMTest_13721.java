import java.io.IOException;

public class MyJVMTest_13721 {

    static CharSequence csq = null;

    static int start = 0;

    static int end = 0;

    Appendable append(CharSequence csq, int start, int end) throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13721().append(csq, start, end));
    }
}
