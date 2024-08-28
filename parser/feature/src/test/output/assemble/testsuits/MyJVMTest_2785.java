import java.awt.Dialog;

public class MyJVMTest_2785 {

    static String line = ";]$1}+4[AO";

    static boolean exception = false;

    static Frame targetFrame = null;

    boolean containsError(String line) {
        line = line.toLowerCase();
        return line.contains("exception") || line.contains("error") || line.contains("selector");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2785().containsError(line));
    }
}
