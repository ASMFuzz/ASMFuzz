import javax.tools.*;

public class MyJVMTest_16889 {

    static boolean ignoreEncodingErrors = false;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test {}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16889().getCharContent(ignoreEncodingErrors));
    }
}
