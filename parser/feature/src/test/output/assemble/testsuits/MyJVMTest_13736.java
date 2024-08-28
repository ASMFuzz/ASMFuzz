import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_13736 {

    static String key = "GP[(&qrX8X";

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    boolean containsErrorKey(String key) {
        return diags.stream().filter(d -> d.getKind() == Diagnostic.Kind.ERROR).anyMatch(d -> d.getCode().equals(key));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13736().containsErrorKey(key));
    }
}
