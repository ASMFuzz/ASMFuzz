import java.io.IOException;
import java.io.InterruptedIOException;

public class MyJVMTest_1301 {

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

    static int DATA_SIZE = 4;

    static char buffer = Character.MAX_VALUE;

    static boolean empty = true;

    void run() {
        try {
            for (int i = 0; i < DATA_SIZE; i++) {
                read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1301().run();
    }
}
