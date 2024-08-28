import java.io.Reader;
import javax.script.Bindings;
import java.io.CharArrayReader;

public class MyJVMTest_12408 {

    static char[] readerParam1 = { Character.MIN_VALUE, Character.MAX_VALUE, ';', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, 'X', Character.MIN_VALUE };

    static Reader reader = new CharArrayReader(readerParam1);

    static Bindings n = null;

    Object eval(Reader reader, Bindings n) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12408().eval(reader, n));
    }
}
