import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_425 {

    static String key = "R\\(\"*,znf\\";

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    boolean containsWarningKey(String key) {
        return diags.stream().filter(d -> d.getKind() == Diagnostic.Kind.WARNING || d.getKind() == Diagnostic.Kind.MANDATORY_WARNING).anyMatch(d -> d.getCode().equals(key));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_425().containsWarningKey(key));
    }
}
