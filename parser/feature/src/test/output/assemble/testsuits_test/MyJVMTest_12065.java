import java.io.IOException;
import java.io.InterruptedIOException;

public class MyJVMTest_12065 {

    static int c = 5;

    static char buffer = Character.MAX_VALUE;

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
        new MyJVMTest_12065().write(c);
    }
}
