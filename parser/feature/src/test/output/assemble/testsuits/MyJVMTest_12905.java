import java.util.Arrays;

public class MyJVMTest_12905 {

    static String string = "Xmo&?bGC+Z";

    byte[] asBytes(String string) {
        byte[] result = new byte[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = (byte) string.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12905().asBytes(string)));
    }
}
