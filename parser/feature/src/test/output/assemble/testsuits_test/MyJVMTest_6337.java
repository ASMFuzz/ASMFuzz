import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class MyJVMTest_6337 {

    static int newCharIndex = 2022745775;

    static int newBoundary = 0;

    static List<Integer> boundaries = new ArrayList<Integer>();

    static int charIndex = 9;

    static int boundaryIndex = 9;

    int changeIndices(int newCharIndex, int newBoundary) {
        boundaryIndex = newBoundary;
        return charIndex = newCharIndex;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6337().changeIndices(newCharIndex, newBoundary));
    }
}
