import java.io.*;

public class MyJVMTest_16899 {

    boolean testBufferedReader() {
        try {
            InputStreamReader isr = null;
            BufferedReader br = new BufferedReader(isr);
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16899().testBufferedReader());
    }
}
