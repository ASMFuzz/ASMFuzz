import java.util.Arrays;

public class MyJVMTest_630 {

    static String s = ".+LDbAB\"Yx";

    byte[] asciibytes(String s) {
        byte[] b = new byte[s.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) s.charAt(i);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_630().asciibytes(s)));
    }
}
