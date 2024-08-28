import java.util.Hashtable;

public class MyJVMTest_2041 {

    static String escapeSequence = "TL=.kN=ZX{";

    static Hashtable sEscapedChars = new Hashtable();

    String namedEscapeToString(String escapeSequence) {
        return (String) sEscapedChars.get(escapeSequence);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2041().namedEscapeToString(escapeSequence));
    }
}
