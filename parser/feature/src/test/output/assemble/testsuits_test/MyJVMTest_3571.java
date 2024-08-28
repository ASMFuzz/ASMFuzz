import java.util.Arrays;

public class MyJVMTest_3571 {

    static String string = "rL&-YjNl@?";

    byte[] asBytes(String string) {
        byte[] result = new byte[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = (byte) string.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3571().asBytes(string)));
    }
}
