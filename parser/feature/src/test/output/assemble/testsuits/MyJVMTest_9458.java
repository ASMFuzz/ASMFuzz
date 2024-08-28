import javax.management.*;

public class MyJVMTest_9458 {

    static String s = "hkzxqXnn!)";

    String setRuntimeException(String s) throws RuntimeException {
        throw new UnsupportedOperationException(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9458().setRuntimeException(s);
    }
}
