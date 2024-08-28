import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class MyJVMTest_15815 {

    static int newCharIndex = 0;

    static int newBoundary = 0;

    static List<Integer> boundaries = new ArrayList<Integer>();

    static int charIndex = 7;

    static int boundaryIndex = -1193946660;

    int changeIndices(int newCharIndex, int newBoundary) {
        boundaryIndex = newBoundary;
        return charIndex = newCharIndex;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15815().changeIndices(newCharIndex, newBoundary));
    }
}
