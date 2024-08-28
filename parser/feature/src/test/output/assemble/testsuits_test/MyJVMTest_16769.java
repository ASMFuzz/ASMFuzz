import javax.tools.*;
import static javax.tools.StandardLocation.*;
import static javax.tools.JavaFileObject.Kind.*;

public class MyJVMTest_16769 {

    static boolean ignoreEncodingErrors = true;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test { NonexistentClass c = null; }";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16769().getCharContent(ignoreEncodingErrors));
    }
}
