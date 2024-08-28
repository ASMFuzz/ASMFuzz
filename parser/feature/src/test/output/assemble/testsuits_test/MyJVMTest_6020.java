import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.tools.*;

public class MyJVMTest_6020 {

    static Diagnostic<? extends JavaFileObject> message = null;

    static boolean verbose = true;

    static Diagnostic<? extends JavaFileObject> last = null;

    Diagnostic<? extends JavaFileObject> report(Diagnostic<? extends JavaFileObject> message) {
        if (verbose)
            System.err.println(message);
        last = message;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6020().report(message);
    }
}
