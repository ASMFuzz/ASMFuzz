import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_2235 {

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    static boolean foundErrors = false;

    void reset() {
        diags.clear();
        foundErrors = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2235().reset();
    }
}
