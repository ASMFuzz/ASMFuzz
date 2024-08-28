import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import javax.tools.*;

public class MyJVMTest_13924 {

    static Diagnostic<? extends JavaFileObject> diagnostic = null;

    static int errors = -1436177893;

    static PrintWriter out = null;

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> diagnostic) {
        out.println(diagnostic);
        switch(diagnostic.getKind()) {
            case ERROR:
                errors++;
        }
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13924().report(diagnostic);
    }
}
