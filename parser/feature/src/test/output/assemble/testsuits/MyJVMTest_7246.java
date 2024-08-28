import javax.tools.*;
import static javax.tools.StandardLocation.*;
import static javax.tools.JavaFileObject.Kind.*;

public class MyJVMTest_7246 {

    static boolean ignoreEncodingErrors = false;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test { NonexistentClass c = null; }";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7246().getCharContent(ignoreEncodingErrors));
    }
}
