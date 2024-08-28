import java.math.*;

public class MyJVMTest_6156 {

    static String badString = "4wN<7=@B4 ";

    String constructWithError(String badString) {
        try {
            BigInteger bi = new BigInteger(badString);
            throw new RuntimeException(badString + " accepted");
        } catch (NumberFormatException e) {
        }
        return badString;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6156().constructWithError(badString);
    }
}
