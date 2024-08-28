import java.io.*;

public class MyJVMTest_11299 {

    static char[] content = {'|','3','E',Character.MIN_VALUE,'0',Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'0'};

    static int limit = 0;

    static int pos = 0;

    int read() throws IOException {
        if (pos >= limit)
            throw new RuntimeException("Read past limit");
        return content[pos++];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11299().read());
    }
}
