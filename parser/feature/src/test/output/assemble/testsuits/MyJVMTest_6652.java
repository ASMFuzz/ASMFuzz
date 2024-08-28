import java.util.Arrays;

public class MyJVMTest_6652 {

    static String s = "iw&KTqwi)q";

    byte[] toByteArray(String s) {
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            bytes[i] = (byte) v;
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6652().toByteArray(s)));
    }
}
