import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_5337 {

    static Diagnostic<? extends JavaFileObject> diagnostic = null;

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    static boolean foundErrors = false;

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> diagnostic) {
        diags.add(diagnostic);
        foundErrors = foundErrors || diagnostic.getKind() == Diagnostic.Kind.ERROR;
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5337().report(diagnostic);
    }
}
