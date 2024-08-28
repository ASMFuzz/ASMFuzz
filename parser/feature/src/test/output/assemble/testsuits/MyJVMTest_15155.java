import java.lang.reflect.Modifier;

public class MyJVMTest_15155 {

    static int test = -1405991019;

    static String expected = "\"F$,S|cG-e";

    int testString(int test, String expected) {
        if (!Modifier.toString(test).equals(expected))
            throw new RuntimeException(test + " yields incorrect toString result");
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15155().testString(test, expected);
    }
}
