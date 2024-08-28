import java.io.ByteArrayInputStream;

public class MyJVMTest_14313 {

    static String s = "|mfx<{_I}#";

    String out(String s) {
        System.out.println(s);
        System.out.flush();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14313().out(s);
    }
}
