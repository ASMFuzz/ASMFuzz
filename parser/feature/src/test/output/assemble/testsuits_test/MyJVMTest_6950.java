import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_6950 {

    static List<String> names = new ArrayList<String>();

    static boolean hasArg = false;

    static String description = "S}%2rZEWe+";

    String getParameters() {
        return hasArg ? "<arg>" : null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6950().getParameters());
    }
}
