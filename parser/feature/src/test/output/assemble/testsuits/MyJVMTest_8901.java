import javax.tools.*;

public class MyJVMTest_8901 {

    static boolean ignoreEncodingErrors = true;

    CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return "class Test {}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8901().getCharContent(ignoreEncodingErrors));
    }
}
