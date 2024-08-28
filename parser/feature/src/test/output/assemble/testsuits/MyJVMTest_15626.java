import java.math.*;

public class MyJVMTest_15626 {

    static String badString = "+.L($T)\\L3";

    String constructWithError(String badString) {
        try {
            BigInteger bi = new BigInteger(badString);
            throw new RuntimeException(badString + " accepted");
        } catch (NumberFormatException e) {
        }
        return badString;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15626().constructWithError(badString);
    }
}
