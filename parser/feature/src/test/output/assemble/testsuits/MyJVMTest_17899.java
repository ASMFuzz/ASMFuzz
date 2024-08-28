import java.io.*;

public class MyJVMTest_17899 {

    static int i = 3;

    boolean fdInUse(int i) {
        return new File("/proc/self/fd/" + i).exists();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17899().fdInUse(i));
    }
}
