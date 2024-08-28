import java.io.*;

public class MyJVMTest_6431 {

    static int t = 0;

    String termString(int t) {
        switch(t) {
            case 0:
                return "\n";
            case 1:
                return "\r";
            case 2:
                return "\r\n";
            default:
                return "";
        }
    }

    String termName(int t) {
        switch(t) {
            case 0:
                return "\\n";
            case 1:
                return "\\r";
            case 2:
                return "\\r\\n";
            default:
                return "";
        }
    }

    void flush() throws IOException {
        uo.flush();
        Thread.currentThread().yield();
        to.flush();
        Thread.currentThread().yield();
    }

    static DataOutputStream uo = null;

    static BufferedWriter to = null;

    static PrintWriter log = null;

    int go(int t) throws IOException {
        for (int ln = 0; ln < 128; ln++) {
            String ts = termString(t);
            StringBuffer s = new StringBuffer(ln + ts.length());
            for (int i = 0; i < ln; i++) s.append('x');
            log.println("[" + ln + "]" + termName(t));
            uo.writeUTF(s.toString());
            s.append(ts);
            to.write(s.toString());
            flush();
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6431().go(t);
    }
}
