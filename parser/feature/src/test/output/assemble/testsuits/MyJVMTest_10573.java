import java.util.Arrays;

public class MyJVMTest_10573 {

    static int dataSize = 0;

    char[] getTestStringChars(int dataSize) {
        char[] chars = new char[dataSize / 2];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('A' + (i % 26));
        }
        return chars;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10573().getTestStringChars(dataSize)));
    }
}
