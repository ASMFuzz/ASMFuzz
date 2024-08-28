import java.util.Hashtable;

public class MyJVMTest_15522 {

    static char c = Character.MIN_VALUE;

    static Hashtable sEscapedChars = new Hashtable();

    boolean isLineDelimiter(char c) {
        return c == '\n' || c == '\r';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15522().isLineDelimiter(c));
    }
}
