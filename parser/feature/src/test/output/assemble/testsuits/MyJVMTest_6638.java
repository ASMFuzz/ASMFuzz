import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class MyJVMTest_6638 {

    static CharacterIterator newText = null;

    static List<Integer> boundaries = new ArrayList<Integer>();

    static int charIndex = 2;

    CharacterIterator setText(CharacterIterator newText) {
        throw new UnsupportedOperationException();
        return newText;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6638().setText(newText);
    }
}
