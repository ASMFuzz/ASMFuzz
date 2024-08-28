import java.util.*;

public class MyJVMTest_12934 {

    static int partial_len = 4;

    byte[] testArrayCopy1(int partial_len) {
        byte[] src = new byte[5];
        byte[] dest = Arrays.copyOf(src, partial_len);
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12934().testArrayCopy1(partial_len)));
    }
}
