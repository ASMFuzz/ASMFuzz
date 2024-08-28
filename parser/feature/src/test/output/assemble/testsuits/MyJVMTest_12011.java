import java.io.*;

public class MyJVMTest_12011 {

    boolean testBufferedWriter() {
        try {
            OutputStreamWriter isr = null;
            BufferedWriter br = new BufferedWriter(isr);
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12011().testBufferedWriter());
    }
}
