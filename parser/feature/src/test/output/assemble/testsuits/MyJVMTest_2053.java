import java.io.*;

public class MyJVMTest_2053 {

    static char[] content = {'0',Character.MIN_VALUE,Character.MAX_VALUE,'0','2',';',Character.MAX_VALUE,Character.MIN_VALUE,'p','0'};

    static int limit = 9;

    static int pos = 0;

    int read() throws IOException {
        if (pos >= limit)
            throw new RuntimeException("Read past limit");
        return content[pos++];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2053().read());
    }
}
