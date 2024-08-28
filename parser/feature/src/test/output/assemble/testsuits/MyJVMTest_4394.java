import java.util.Arrays;

public class MyJVMTest_4394 {

    static String str = "C/7@u3EGct";

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
        System.out.println(Arrays.asList(new MyJVMTest_4394().hexStringToByteArray(str)));
    }
}
