import java.util.Arrays;

public class MyJVMTest_13769 {

    static String str = "3jDvDFXd{p";

    byte[] hexStringToByteArray(String str) {
        byte[] result = new byte[str.length() / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) Character.digit(str.charAt(2 * i), 16);
            result[i] <<= 4;
            result[i] += Character.digit(str.charAt(2 * i + 1), 16);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13769().hexStringToByteArray(str)));
    }
}
