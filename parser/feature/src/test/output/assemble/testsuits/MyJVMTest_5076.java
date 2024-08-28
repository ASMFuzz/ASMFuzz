import java.io.*;

public class MyJVMTest_5076 {

    void doTest() {
        try {
            File file = File.createTempFile("DeleteOnExitNPE", null);
            file.deleteOnExit();
            Thread thread = new Thread(new DeleteOnExitNPE());
            thread.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.exit(0);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5076().doTest();
    }
}
