import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import static javax.tools.Diagnostic.Kind.*;
import java.io.*;
import java.util.HashSet;

public class MyJVMTest_6659 {

    static Set<? extends TypeElement> tes = new HashSet<? extends TypeElement>();

    static RoundEnvironment renv = null;

    void copy(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[8192];
        int n;
        while ((n = is.read(buf, 0, buf.length)) > 0) os.write(buf, 0, n);
    }

    static Messager msgr = null;

    static Filer filer = null;

    static boolean DONE = false;

    boolean process(Set<? extends TypeElement> tes, RoundEnvironment renv) {
        boolean ret = true;
        if (!renv.processingOver() && !DONE) {
            msgr.printMessage(NOTE, "running process to create HelloWorld.");
            try {
                Writer pw = filer.createSourceFile("HelloWorld").openWriter();
                pw.write("public class HelloWorld {\n");
                pw.write("  public static void main (String argv[]) {\n");
                pw.write("    System.out.println(\"Hello apt world.\");\n");
                pw.write("  }\n");
                pw.write("}\n");
                pw.flush();
                pw.close();
                OutputStream os = filer.createClassFile("HelloWorldAP").openOutputStream();
                InputStream is = getClass().getResourceAsStream("HelloWorldAP.class");
                copy(is, os);
                is.close();
                os.flush();
                os.close();
                DONE = true;
            } catch (IOException ioe) {
                msgr.printMessage(ERROR, ioe.getMessage());
                ret = false;
            } catch (Exception e) {
                msgr.printMessage(ERROR, e.getMessage());
                ret = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6659().process(tes, renv));
    }
}
