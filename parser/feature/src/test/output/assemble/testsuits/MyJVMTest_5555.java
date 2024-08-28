import java.util.Random;

public class MyJVMTest_5555 {

    static Random rnd = new Random();

    static int ITERATIONS = 1000;

    static int STR_LEN = 20;

    void testString() throws Exception {
        for (int i = 0; i < ITERATIONS; i++) {
            int length = rnd.nextInt(STR_LEN) + 1;
            StringBuilder testStringBuilder = new StringBuilder();
            for (int x = 0; x < length; x++) {
                char aChar = (char) rnd.nextInt();
                testStringBuilder.append(aChar);
            }
            String testString = testStringBuilder.toString();
            char c = testStringBuilder.charAt(0);
            testStringBuilder.setCharAt(0, 'c');
            testStringBuilder.setCharAt(0, c);
            if (!testString.contentEquals(testStringBuilder.toString()))
                throw new RuntimeException("ContentsEqual failure");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5555().testString();
    }
}
