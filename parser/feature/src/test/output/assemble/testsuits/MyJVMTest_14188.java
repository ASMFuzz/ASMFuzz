import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.interfaces.*;

public class MyJVMTest_14188 {

    static ByteBuffer bbIn = null;

    static ByteBuffer bbOut = null;

    static Status resultParam1 = null;

    static HandshakeStatus resultParam2 = null;

    static int resultParam3 = 684;

    static int resultParam4 = 198;

    static SSLEngineResult result = new SSLEngineResult(resultParam1, resultParam2, resultParam3, resultParam4);

    static Status status = null;

    static HandshakeStatus hsStatus = null;

    static int consumed = 7;

    static int produced = -650578596;

    static SSLContext sslc = null;

    SSLEngineResult checkResult(ByteBuffer bbIn, ByteBuffer bbOut, SSLEngineResult result, Status status, HandshakeStatus hsStatus, int consumed, int produced) throws Exception {
        if ((status != null) && (result.getStatus() != status)) {
            throw new Exception("Unexpected Status: need = " + status + " got = " + result.getStatus());
        }
        if ((hsStatus != null) && (result.getHandshakeStatus() != hsStatus)) {
            throw new Exception("Unexpected hsStatus: need = " + hsStatus + " got = " + result.getHandshakeStatus());
        }
        if ((consumed != -1) && (consumed != result.bytesConsumed())) {
            throw new Exception("Unexpected consumed: need = " + consumed + " got = " + result.bytesConsumed());
        }
        if ((produced != -1) && (produced != result.bytesProduced())) {
            throw new Exception("Unexpected produced: need = " + produced + " got = " + result.bytesProduced());
        }
        if ((consumed != -1) && (bbIn.position() != result.bytesConsumed())) {
            throw new Exception("Consumed " + bbIn.position() + " != " + consumed);
        }
        if ((produced != -1) && (bbOut.position() != result.bytesProduced())) {
            throw new Exception("produced " + bbOut.position() + " != " + produced);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14188().checkResult(bbIn, bbOut, result, status, hsStatus, consumed, produced);
    }
}
