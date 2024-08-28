import java.io.*;

public class MyJVMTest_2729 {

    static DataInputStream ui = null;

    static BufferedReader ti = null;

    static int count = 8;

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
        System.out.println(new MyJVMTest_2729().readUTFLine());
    }
}
