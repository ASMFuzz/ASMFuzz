import java.net.*;

public class MyJVMTest_14055 {

    boolean finished() {
        return (isFinished);
    }

    static ServerSocket server = null;

    static boolean isFinished = false;

    void run() {
        try {
            Socket s = server.accept();
            s.close();
            while (!finished()) {
                Thread.sleep(500);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14055().run();
    }
}
