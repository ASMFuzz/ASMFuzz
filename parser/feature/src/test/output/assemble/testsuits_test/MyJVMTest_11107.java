import java.io.Reader;
import java.io.CharArrayReader;

public class MyJVMTest_11107 {

    static char[] readerParam1 = { Character.MAX_VALUE, 'H', Character.MAX_VALUE, '0', Character.MAX_VALUE, '=', Character.MAX_VALUE, '0', '0', '>' };

    static Reader reader = new CharArrayReader(readerParam1);

    Object eval(Reader reader) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11107().eval(reader));
    }
}
