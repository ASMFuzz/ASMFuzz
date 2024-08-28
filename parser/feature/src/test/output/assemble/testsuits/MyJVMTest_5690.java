import java.io.*;

public class MyJVMTest_5690 {

    static File file = null;

    void run() {
        Console cons = System.console();
        file.deleteOnExit();
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("file is being deleted");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5690().run();
    }
}
