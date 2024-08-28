import java.util.Hashtable;

public class MyJVMTest_11286 {

    static String escapeSequence = "oPSqQFiz.3";

    static Hashtable sEscapedChars = new Hashtable();

    String namedEscapeToString(String escapeSequence) {
        return (String) sEscapedChars.get(escapeSequence);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11286().namedEscapeToString(escapeSequence));
    }
}
