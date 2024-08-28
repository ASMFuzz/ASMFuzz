import java.io.Reader;
import java.io.CharArrayReader;

public class MyJVMTest_1878 {

    static char[] readerParam1 = { 'W', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', '0', '0', Character.MIN_VALUE };

    static int readerParam2 = 820;

    static int readerParam3 = 860;

    static Reader reader = new CharArrayReader(readerParam1, readerParam2, readerParam3);

    Object eval(Reader reader) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1878().eval(reader));
    }
}
