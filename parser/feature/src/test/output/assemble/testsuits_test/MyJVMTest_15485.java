import java.util.Hashtable;

public class MyJVMTest_15485 {

    static char c = 'K';

    static Hashtable sEscapedChars = new Hashtable();

    boolean isLetter(char c) {
        return (c >= 'A' && c <= 'z');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15485().isLetter(c));
    }
}
