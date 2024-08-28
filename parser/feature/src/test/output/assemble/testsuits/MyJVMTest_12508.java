import java.security.*;

public class MyJVMTest_12508 {

    static String param = "e+z^Jamv%b";

    Object engineGetParameter(String param) throws InvalidParameterException {
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12508().engineGetParameter(param));
    }
}
