import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_16465 {

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    boolean errorsFound() {
        return diags.stream().anyMatch(d -> d.getKind() == Diagnostic.Kind.ERROR);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16465().errorsFound());
    }
}
