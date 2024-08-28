import java.util.Hashtable;

public class MyJVMTest_17954 {

    static char c = Character.MIN_VALUE;

    static Hashtable sEscapedChars = new Hashtable();

    boolean isSpace(char c) {
        return c == ' ';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17954().isSpace(c));
    }
}
