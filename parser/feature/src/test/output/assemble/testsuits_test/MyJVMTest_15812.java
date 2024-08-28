import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_15812 {

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setEnabledCipherSuites(cliEnabledCipherSuites);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        sslSocket.close();
    }

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] cliEnabledCipherSuites = {"{{zy|t4uM'","E?k8+F~Ve1","m~xR}Ib4aa","q&x)XL<RHm","BGoe3.dwj}","Wxf#/PhWA+","vr/Z|sDEgJ","gkA\"X7ET#~",";}(T^{iAg1","| 8pV%4 .}"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void startClient(boolean newThread) throws Exception {
        if (newThread) {
            clientThread = new Thread() {

                public void run() {
                    try {
                        doClientSide();
                    } catch (Exception e) {
                        System.err.println("Client died...");
                        clientException = e;
                    }
                }
            };
            clientThread.start();
        } else {
            try {
                doClientSide();
            } catch (Exception e) {
                clientException = e;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15812().run();
    }
}
