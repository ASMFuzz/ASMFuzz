import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_6944 {

    static String key = "*q!!Vn02SY";

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    boolean containsWarningKey(String key) {
        return diags.stream().filter(d -> d.getKind() == Diagnostic.Kind.WARNING).anyMatch(d -> d.getCode().equals(key));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6944().containsWarningKey(key));
    }
}
