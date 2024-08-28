import java.security.*;

public class MyJVMTest_8173 {

    static String param = "2-01HK80`j";

    static Object value = 7;

    Object engineSetParameter(String param, Object value) throws InvalidParameterException {
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8173().engineSetParameter(param, value);
    }
}
