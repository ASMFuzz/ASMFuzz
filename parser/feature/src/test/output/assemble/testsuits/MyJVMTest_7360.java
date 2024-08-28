import javax.tools.*;

public class MyJVMTest_7360 {

    static boolean ignoreEncodingErrors = false;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test {}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7360().getCharContent(ignoreEncodingErrors));
    }
}
