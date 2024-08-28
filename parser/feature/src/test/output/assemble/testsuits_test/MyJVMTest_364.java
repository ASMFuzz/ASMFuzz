import java.io.Reader;

public class MyJVMTest_364 {

    static int len = 1750884501;

    static int count = 0;

    static char next = 'a';

    int read() {
        if (count >= len)
            return -1;
        char c = next;
        if (next == 'z')
            next = '0';
        else if (next == '9')
            next = 'a';
        else
            next++;
        count++;
        return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_364().read());
    }
}
