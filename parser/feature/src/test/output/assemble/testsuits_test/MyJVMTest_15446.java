import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_15446 {

    static String option = "a^T:(HBG}^";

    static List<String> arguments = new ArrayList<String>();

    static boolean OK = true;

    static boolean verbose = false;

    static List<String> names = new ArrayList<String>();

    static boolean hasArg = true;

    static String description = "zggCAr#J}s";

    boolean process(String option, List<String> arguments) {
        verbose = true;
        return OK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15446().process(option, arguments));
    }
}
