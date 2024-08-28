import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_1730 {

    static int ndx = 0;

    static int exitCode = 0;

    static List<String> stdout = new ArrayList<String>();

    static List<String> stderr = new ArrayList<String>();

    String getStdoutLine(int ndx) {
        return stdout.get(ndx);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1730().getStdoutLine(ndx));
    }
}
