import java.util.Hashtable;

public class MyJVMTest_6064 {

    static char c = Character.MAX_VALUE;

    static Hashtable sEscapedChars = new Hashtable();

    boolean isLineDelimiter(char c) {
        return c == '\n' || c == '\r';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6064().isLineDelimiter(c));
    }
}
