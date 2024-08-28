import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_17072 {

    static String option = "E:vR}b Rhl";

    static List<String> arguments = new ArrayList<String>();

    static boolean OK = true;

    static List<String> names = new ArrayList<String>();

    static boolean hasArg = true;

    static String description = "aJJ%pG$SWA";

    boolean process(String option, List<String> arguments) {
        System.out.println("received option " + option + " " + arguments);
        return OK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17072().process(option, arguments));
    }
}
