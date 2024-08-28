import java.util.Random;

public class MyJVMTest_5485 {

    static Random rnd = new Random();

    static int ITERATIONS = 1000;

    static int STR_LEN = 20;

    void testStringBuffer() throws Exception {
        for (int i = 0; i < ITERATIONS; i++) {
            int length = rnd.nextInt(STR_LEN) + 1;
            StringBuffer testStringBuffer = new StringBuffer();
            for (int x = 0; x < length; x++) {
                char aChar = (char) rnd.nextInt();
                testStringBuffer.append(aChar);
            }
            String testString = testStringBuffer.toString();
            char c = testStringBuffer.charAt(0);
            testStringBuffer.setCharAt(0, 'c');
            testStringBuffer.setCharAt(0, c);
            if (!testString.contentEquals(testStringBuffer))
                throw new RuntimeException("ContentsEqual failure");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5485().testStringBuffer();
    }
}
