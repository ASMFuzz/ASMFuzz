import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_797 {

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    void reset() {
        diags.clear();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_797().reset();
    }
}
