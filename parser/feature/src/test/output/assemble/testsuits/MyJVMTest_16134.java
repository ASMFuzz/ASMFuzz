import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class MyJVMTest_16134 {

    static CharacterIterator newText = null;

    static List<Integer> boundaries = new ArrayList<Integer>();

    static int charIndex = 345346522;

    CharacterIterator setText(CharacterIterator newText) {
        throw new UnsupportedOperationException();
        return newText;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16134().setText(newText);
    }
}
