import java.io.Reader;

public class MyJVMTest_5671 {

    static String script = "pEOg?r5+z3";

    Object eval(String script) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5671().eval(script));
    }
}
