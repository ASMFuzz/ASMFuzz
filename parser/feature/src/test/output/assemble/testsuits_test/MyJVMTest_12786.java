import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class MyJVMTest_12786 {

    static List<Integer> boundaries = new ArrayList<Integer>();

    static int charIndex = 8;

    CharacterIterator getText() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12786().getText());
    }
}
