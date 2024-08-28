import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_10557 {

    static PrinterJob pj = null;

    static boolean okayed = false;

    void run() {
        boolean cancelWorked = false;
        try {
            pj.print();
        } catch (PrinterAbortException paex) {
            cancelWorked = true;
            System.out.println("Job was properly cancelled and we");
            System.out.println("got the expected PrintAbortException");
        } catch (PrinterException prex) {
            System.out.println("This is wrong .. we shouldn't be here");
            System.out.println("Looks like a test failure");
            prex.printStackTrace();
        } finally {
            System.out.println("DONE PRINTING");
            if (!cancelWorked) {
                System.out.println("Looks like the test failed - we didn't get");
                System.out.println("the expected PrintAbortException ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10557().run();
    }
}
