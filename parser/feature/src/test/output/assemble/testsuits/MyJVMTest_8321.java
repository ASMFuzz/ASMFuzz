import java.io.*;

public class MyJVMTest_8321 {

    static int i = 4;

    boolean fdInUse(int i) {
        return new File("/proc/self/fd/" + i).exists();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8321().fdInUse(i));
    }
}
