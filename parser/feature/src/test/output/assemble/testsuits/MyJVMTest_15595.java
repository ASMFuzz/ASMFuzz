import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;

public class MyJVMTest_15595 {

    static int i = 4;

    SSLEngineResult test(int i) throws Exception {
        SSLEngineResult result;
        try {
            switch(i) {
                case 0:
                    result = new SSLEngineResult(null, HandshakeStatus.NOT_HANDSHAKING, 0, 0);
                    return;
                case 1:
                    result = new SSLEngineResult(Status.OK, null, 0, 0);
                    return;
                case 2:
                    result = new SSLEngineResult(Status.OK, HandshakeStatus.NOT_HANDSHAKING, -1, 0);
                    return;
                case 3:
                    result = new SSLEngineResult(Status.OK, HandshakeStatus.NOT_HANDSHAKING, 0, -1);
                    return;
            }
            throw new Exception("Didn't throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("Threw right Exception");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15595().test(i);
    }
}
