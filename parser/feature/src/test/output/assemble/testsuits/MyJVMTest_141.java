import java.io.IOException;

public class MyJVMTest_141 {

    static char c = '0';

    Appendable append(char c) throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_141().append(c));
    }
}
