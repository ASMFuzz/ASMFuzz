import java.io.IOException;

public class MyJVMTest_12263 {

    static CharSequence csq = null;

    Appendable append(CharSequence csq) throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12263().append(csq));
    }
}
