import java.io.IOException;

public class MyJVMTest_4347 {

    static CharSequence csq = null;

    static int start = 5;

    static int end = 0;

    Appendable append(CharSequence csq, int start, int end) throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4347().append(csq, start, end));
    }
}
