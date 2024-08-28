import java.util.*;

public class MyJVMTest_3599 {

    static int partial_len = 1;

    byte[] testArrayCopy1(int partial_len) {
        byte[] src = new byte[5];
        byte[] dest = Arrays.copyOf(src, partial_len);
        return dest;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3599().testArrayCopy1(partial_len)));
    }
}
