import java.io.IOException;

public class MyJVMTest_9289 {

    static char c = 't';

    Appendable append(char c) throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9289().append(c));
    }
}
