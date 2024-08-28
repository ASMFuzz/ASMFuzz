import java.util.*;
import javax.tools.*;
import static javax.tools.StandardLocation.*;
import static javax.tools.JavaFileObject.Kind.*;

public class MyJVMTest_9937 {

    static JavaFileManager fm = null;

    static JavaFileManager.Location location = null;

    static String packageName = "=yX<^drC`)";

    static Set<JavaFileObject.Kind> kinds = new HashSet<JavaFileObject.Kind>();

    String testList(JavaFileManager fm, JavaFileManager.Location location, String packageName, Set<JavaFileObject.Kind> kinds) throws Exception {
        boolean expectNpe = location == null || packageName == null || kinds == null;
        try {
            fm.list(location, packageName, kinds, false);
            if (expectNpe) {
                String message = "NullPointerException not thrown";
                if (location == null)
                    throw new AssertionError(message + " (location is null)");
                if (packageName == null)
                    throw new AssertionError(message + " (packageName is null)");
                if (kinds == null)
                    throw new AssertionError(message + " (kinds is null)");
                throw new AssertionError(message);
            }
        } catch (NullPointerException e) {
            if (!expectNpe)
                throw e;
        }
        return packageName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9937().testList(fm, location, packageName, kinds);
    }
}
