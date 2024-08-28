import java.io.IOException;
import java.io.InterruptedIOException;

public class MyJVMTest_11718 {

    static char buffer = '0';

    static boolean empty = true;

    int read() throws IOException {
        while (empty) {
            try {
                System.out.println("read() before wait");
                wait(1000);
                System.out.println("read() after wait");
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }
        int value = buffer;
        empty = true;
        notifyAll();
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11718().read());
    }
}
