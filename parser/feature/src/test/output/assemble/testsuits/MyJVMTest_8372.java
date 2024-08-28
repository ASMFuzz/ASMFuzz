import java.util.Hashtable;

public class MyJVMTest_8372 {

    static char c = '0';

    static Hashtable sEscapedChars = new Hashtable();

    boolean isSpace(char c) {
        return c == ' ';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8372().isSpace(c));
    }
}
