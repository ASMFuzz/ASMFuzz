import java.io.BufferedReader;
import java.io.IOException;

public class MyJVMTest_10645 {

    static BufferedReader in = null;

    void run() {
        try {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("testvm: " + line);
            }
            System.out.flush();
        } catch (IOException exc) {
            System.err.println("Child I/O Transfer - " + exc);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10645().run();
    }
}
