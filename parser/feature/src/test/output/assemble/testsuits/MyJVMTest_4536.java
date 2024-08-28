import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import javax.tools.*;

public class MyJVMTest_4536 {

    static Diagnostic<? extends JavaFileObject> diagnostic = null;

    static int errors = -105825176;

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
        new MyJVMTest_4536().report(diagnostic);
    }
}
