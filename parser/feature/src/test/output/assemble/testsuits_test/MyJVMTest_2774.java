import java.io.IOException;
import java.io.InterruptedIOException;

public class MyJVMTest_2774 {

    static int c = 0;

    static char buffer = 'h';

    static boolean empty = true;

    int write(int c) throws IOException {
        while (!empty) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }
        buffer = (char) c;
        empty = false;
        notifyAll();
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2774().write(c);
    }
}
