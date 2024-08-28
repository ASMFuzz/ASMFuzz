import java.awt.Dialog;

public class MyJVMTest_12078 {

    static String line = ";DNgU7-R;s";

    static boolean exception = false;

    static Frame targetFrame = null;

    boolean containsError(String line) {
        line = line.toLowerCase();
        return line.contains("exception") || line.contains("error") || line.contains("selector");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12078().containsError(line));
    }
}
