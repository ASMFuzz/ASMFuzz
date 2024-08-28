import java.util.Arrays;

public class MyJVMTest_9797 {

    static String s = "vrGp#R//wo";

    byte[] asciibytes(String s) {
        byte[] b = new byte[s.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) s.charAt(i);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9797().asciibytes(s)));
    }
}
