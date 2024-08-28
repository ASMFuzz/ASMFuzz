import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_2202 {

    static long granularityperiod = 0;

    static String caller = "iwG:9v@ gR";

    void echo(String message) {
        System.out.println(message);
    }

    static boolean messageReceived = false;

    int checkReceived(long granularityperiod, String caller) throws InterruptedException {
        int i = 100;
        do {
            Thread.sleep(granularityperiod);
        } while (!messageReceived && i-- > 0);
        if (messageReceived) {
            echo("\tOK: " + caller + " notification received");
        } else {
            echo("\tKO: " + caller + " notification missed or not emitted");
        }
        return messageReceived ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2202().checkReceived(granularityperiod, caller));
    }
}
