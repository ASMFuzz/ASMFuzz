import java.io.*;

public class MyJVMTest_1715 {

    String readUTFLine() throws IOException {
        String s;
        try {
            s = ui.readUTF();
        } catch (EOFException x) {
            return null;
        }
        return s;
    }

    static DataInputStream ui = null;

    static BufferedReader ti = null;

    static int count = 302242303;

    static PrintWriter log = null;

    void run() {
        try {
            for (int ln = 0; ln < count; ln++) {
                String us = readUTFLine();
                if (us == null) {
                    if (count < Integer.MAX_VALUE)
                        throw new RuntimeException("Premature EOF on UTF stream");
                    log.println("EOF on UTF stream");
                    break;
                }
                String ts = ti.readLine();
                if (ts == null) {
                    if (count < Integer.MAX_VALUE)
                        throw new RuntimeException("Premature EOF on char stream");
                    log.println("EOF on char stream");
                    break;
                }
                if (us.length() != ts.length()) {
                    log.println("Length mismatch: us = \"" + us + "\", ts = \"" + ts + "\"");
                    throw new RuntimeException("Line " + ln + ": Length mismatch: " + us.length() + " " + ts.length());
                }
                for (int i = 0; i < us.length(); i++) {
                    if (us.charAt(i) != ts.charAt(i))
                        throw new RuntimeException("Line " + ln + ": Char mismatch: [" + i + "] " + Integer.toHexString(us.charAt(i)) + " " + Integer.toHexString(ts.charAt(i)));
                }
                log.println(ln + " " + ts.length());
            }
            if (readUTFLine() != null)
                throw new RuntimeException("Expected EOF on UTF stream");
            if (ti.readLine() != null)
                throw new RuntimeException("Expected EOF on char stream");
        } catch (IOException x) {
            throw new RuntimeException("Unexpected IOException: " + x);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1715().run();
    }
}
