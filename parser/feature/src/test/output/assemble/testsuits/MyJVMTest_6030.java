import java.util.Hashtable;

public class MyJVMTest_6030 {

    static char c = Character.MIN_VALUE;

    static Hashtable sEscapedChars = new Hashtable();

    boolean isLetter(char c) {
        return (c >= 'A' && c <= 'z');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6030().isLetter(c));
    }
}
