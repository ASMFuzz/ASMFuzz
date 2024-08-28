import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_10953 {

    static int ndx = -669738602;

    static int exitCode = 4;

    static List<String> stdout = new ArrayList<String>();

    static List<String> stderr = new ArrayList<String>();

    String getStdoutLine(int ndx) {
        return stdout.get(ndx);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10953().getStdoutLine(ndx));
    }
}
