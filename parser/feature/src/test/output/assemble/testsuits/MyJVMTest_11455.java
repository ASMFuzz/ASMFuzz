import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_11455 {

    static long granularityperiod = 9223372036854775807L;

    static String caller = "SGJ<wvuUCN";

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
        System.out.println(new MyJVMTest_11455().checkReceived(granularityperiod, caller));
    }
}
