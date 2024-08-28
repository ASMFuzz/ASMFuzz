import java.io.IOException;

public class MyJVMTest_13986 {

    static int shortFall = 908676279;

    static byte next = 0;

    int read() throws IOException {
        return next++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13986().read());
    }
}
