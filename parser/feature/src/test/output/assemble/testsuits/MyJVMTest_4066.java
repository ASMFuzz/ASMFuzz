import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;
import javax.net.ssl.*;

public class MyJVMTest_4066 {

    static ByteBuffer resCliHello = null;

    static String HOST_NAME = "arf.yak.foo";

    ByteBuffer checkResumedClientHelloSNI(ByteBuffer resCliHello) throws Exception {
        boolean foundMatchingSNI = false;
        boolean foundPSK = false;
        resCliHello.position(resCliHello.position() + 5);
        byte hsMsgType = resCliHello.get();
        if (hsMsgType != 0x01) {
            throw new Exception("Message is not a ClientHello, MsgType = " + hsMsgType);
        }
        resCliHello.position(resCliHello.position() + 3);
        short chProto = resCliHello.getShort();
        if (chProto != 0x0303) {
            throw new Exception("Client Hello protocol version is not TLSv1.2: Got " + String.format("0x%04X", chProto));
        }
        resCliHello.position(resCliHello.position() + 32);
        int sessIdLen = Byte.toUnsignedInt(resCliHello.get());
        resCliHello.position(resCliHello.position() + sessIdLen);
        int csLen = Short.toUnsignedInt(resCliHello.getShort());
        resCliHello.position(resCliHello.position() + csLen);
        int compLen = Byte.toUnsignedInt(resCliHello.get());
        resCliHello.position(resCliHello.position() + compLen);
        System.err.println("ClientHello Extensions Check");
        int extListLen = Short.toUnsignedInt(resCliHello.getShort());
        while (extListLen > 0) {
            int extType = Short.toUnsignedInt(resCliHello.getShort());
            int extLen = Short.toUnsignedInt(resCliHello.getShort());
            switch(extType) {
                case 0:
                    System.err.println("* Found server_name Extension");
                    int snListLen = Short.toUnsignedInt(resCliHello.getShort());
                    while (snListLen > 0) {
                        int nameType = Byte.toUnsignedInt(resCliHello.get());
                        if (nameType == 0) {
                            int hostNameLen = Short.toUnsignedInt(resCliHello.getShort());
                            byte[] hostNameData = new byte[hostNameLen];
                            resCliHello.get(hostNameData);
                            String hostNameStr = new String(hostNameData);
                            System.err.println("\tHostname: " + hostNameStr);
                            if (hostNameStr.equals(HOST_NAME)) {
                                foundMatchingSNI = true;
                            }
                            snListLen -= 3 + hostNameLen;
                        } else {
                            throw new Exception("Unknown server name type: " + nameType);
                        }
                    }
                    break;
                case 41:
                    foundPSK = true;
                    System.err.println("* Found pre_shared_key Extension");
                    resCliHello.position(resCliHello.position() + extLen);
                    break;
                default:
                    System.err.format("* Found extension %d (%d bytes)\n", extType, extLen);
                    resCliHello.position(resCliHello.position() + extLen);
                    break;
            }
            extListLen -= extLen + 4;
        }
        if (!foundMatchingSNI) {
            throw new Exception("Could not find a matching server_name");
        } else if (!foundPSK) {
            throw new Exception("Missing PSK extension, not a resumption?");
        }
        return resCliHello;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4066().checkResumedClientHelloSNI(resCliHello);
    }
}
