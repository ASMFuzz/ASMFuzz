import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_7313 {

    static Diagnostic<? extends JavaFileObject> diagnostic = null;

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> diagnostic) {
        diags.add(diagnostic);
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7313().report(diagnostic);
    }
}
