import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_14428 {

    static List<String> names = new ArrayList<String>();

    static boolean hasArg = false;

    static String description = "/V`AF%a+a[";

    String getName() {
        return "MyDoclet";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14428().getName());
    }
}
