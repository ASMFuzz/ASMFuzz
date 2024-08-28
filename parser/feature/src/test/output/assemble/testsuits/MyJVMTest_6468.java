import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_6468 {

    static List<String> names = new ArrayList<String>();

    static boolean hasArg = true;

    static String description = "W'iYEl75=\"";

    int getArgumentCount() {
        return hasArg ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6468().getArgumentCount());
    }
}
