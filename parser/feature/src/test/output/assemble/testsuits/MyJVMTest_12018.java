import java.io.*;

public class MyJVMTest_12018 {

    static DataInputStream ui = null;

    static BufferedReader ti = null;

    static int count = 4;

    static PrintWriter log = null;

    String readUTFLine() throws IOException {
        String s;
        try {
            s = ui.readUTF();
        } catch (EOFException x) {
            return null;
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12018().readUTFLine());
    }
}
