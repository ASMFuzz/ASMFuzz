import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MyJVMTest_3645 {

    static boolean ignoreEncodingErrors = true;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test { }";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3645().getCharContent(ignoreEncodingErrors));
    }
}
