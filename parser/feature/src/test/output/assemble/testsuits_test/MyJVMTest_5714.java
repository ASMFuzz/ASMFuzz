import java.lang.reflect.Modifier;

public class MyJVMTest_5714 {

    static int test = 1;

    static String expected = "LMeQMHS,g:";

    int testString(int test, String expected) {
        if (!Modifier.toString(test).equals(expected))
            throw new RuntimeException(test + " yields incorrect toString result");
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5714().testString(test, expected);
    }
}
