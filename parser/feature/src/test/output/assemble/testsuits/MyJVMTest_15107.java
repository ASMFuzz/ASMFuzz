import java.io.Reader;

public class MyJVMTest_15107 {

    static String script = "|6:cR5_DSw";

    Object eval(String script) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15107().eval(script));
    }
}
