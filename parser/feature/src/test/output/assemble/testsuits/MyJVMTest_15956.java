import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_15956 {

    static List<String> names = new ArrayList<String>();

    static boolean hasArg = false;

    static String description = ",Wa&bY&&#F";

    int getArgumentCount() {
        return hasArg ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15956().getArgumentCount());
    }
}
