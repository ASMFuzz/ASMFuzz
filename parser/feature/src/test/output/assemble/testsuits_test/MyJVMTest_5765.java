import java.io.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.tools.*;

public class MyJVMTest_5765 {

    static Diagnostic<? extends JavaFileObject> diagnostic = null;

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> diagnostic) {
        throw new IllegalStateException(diagnostic.toString());
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5765().report(diagnostic);
    }
}
