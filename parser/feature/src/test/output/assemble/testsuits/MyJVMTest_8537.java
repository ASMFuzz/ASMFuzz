import java.util.*;
import static java.lang.Character.*;

public class MyJVMTest_8537 {

    static int i = 7;

    static Locale turkish = new Locale("tr");

    String charProps(int i) {
        String s = new String(new int[] { i }, 0, 1);
        return String.format("%b %b %b %b %b %b %b %b %b %b %b %b %d %d %d %d %d %b %b %d %d %b %d %d", isLowerCase(i), isUpperCase(i), isTitleCase(i), isDigit(i), isDefined(i), isLetter(i), isLetterOrDigit(i), isJavaIdentifierStart(i), isJavaIdentifierPart(i), isUnicodeIdentifierStart(i), isUnicodeIdentifierPart(i), isIdentifierIgnorable(i), toLowerCase(i), toUpperCase(i), toTitleCase(i), digit(i, 16), getNumericValue(i), isSpaceChar(i), isWhitespace(i), getType(i), getDirectionality(i), isMirrored(i), (int) s.toUpperCase(Locale.GERMAN).charAt(0), (int) s.toUpperCase(turkish).charAt(0));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8537().charProps(i));
    }
}
