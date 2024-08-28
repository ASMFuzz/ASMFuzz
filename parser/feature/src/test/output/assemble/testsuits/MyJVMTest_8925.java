import java.io.IOException;
import java.io.InterruptedIOException;

public class MyJVMTest_8925 {

    static char buffer = Character.MAX_VALUE;

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
        System.out.println(new MyJVMTest_8925().read());
    }
}
