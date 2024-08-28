import java.io.IOException;

public class MyJVMTest_4596 {

    static int shortFall = 6;

    static byte next = 0;

    int read() throws IOException {
        return next++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4596().read());
    }
}
