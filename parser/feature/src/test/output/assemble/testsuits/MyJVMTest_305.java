import javax.management.*;

public class MyJVMTest_305 {

    static String s = "f%]+&E(06V";

    String setRuntimeException(String s) throws RuntimeException {
        throw new UnsupportedOperationException(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_305().setRuntimeException(s);
    }
}
