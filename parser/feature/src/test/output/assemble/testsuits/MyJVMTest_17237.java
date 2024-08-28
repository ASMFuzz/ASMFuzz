import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.util.*;

public class MyJVMTest_17237 {

    static String str = "/_{C%,+-\"z";

    static Status resultParam1 = null;

    static HandshakeStatus resultParam2 = null;

    static int resultParam3 = 684;

    static int resultParam4 = 235;

    static SSLEngineResult result = new SSLEngineResult(resultParam1, resultParam2, resultParam3, resultParam4);

    SSLEngineResult logResult(String str, SSLEngineResult result) {
        HandshakeStatus hsStatus = result.getHandshakeStatus();
        System.out.println(str + result.getStatus() + "/" + hsStatus + ", " + result.bytesConsumed() + "/" + result.bytesProduced() + " bytes");
        if (hsStatus == HandshakeStatus.FINISHED) {
            System.out.println("\t...ready for application data");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17237().logResult(str, result);
    }
}
