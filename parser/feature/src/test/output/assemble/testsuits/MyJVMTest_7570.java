import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_7570 {

    static String key = "/nXFEO9l.h";

    static List<Diagnostic<? extends JavaFileObject>> diags = new ArrayList<>();

    Diagnostic<?> getDiagWithKey(String key) {
        for (Diagnostic<?> d : diags) {
            if (d.getCode().equals(key)) {
                return d;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7570().getDiagWithKey(key));
    }
}
