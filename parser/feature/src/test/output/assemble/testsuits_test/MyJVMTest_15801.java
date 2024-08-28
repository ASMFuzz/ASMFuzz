import java.util.Arrays;

public class MyJVMTest_15801 {

    static byte[] elems = new byte[64];

    static int offset = 0;

    byte[] bytes() {
        byte[] bytes = new byte[offset];
        System.arraycopy(elems, 0, bytes, 0, offset);
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15801().bytes()));
    }
}
