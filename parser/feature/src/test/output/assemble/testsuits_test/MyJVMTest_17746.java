import java.security.*;

public class MyJVMTest_17746 {

    static String param = "e0J %nWL&0";

    static Object value = 6;

    Object engineSetParameter(String param, Object value) throws InvalidParameterException {
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17746().engineSetParameter(param, value);
    }
}
