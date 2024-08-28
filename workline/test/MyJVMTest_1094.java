import java.util.Random;

public class MyJVMTest_1094 {

    static long randomParam1 = -9223372036854775808L;

    static Random random = new Random(randomParam1);

    static char[] SYMBOL = { Character.MIN_VALUE, '0', Character.MAX_VALUE, 'B', Character.MAX_VALUE, '0', 'E', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static int length = 595636583;

    String nextString(Random random, char[] SYMBOL, int length) throws Exception {
        StringBuilder sb = new StringBuilder(length);
        for (int index = 0; index < length; ) {
            int nextChar = random.nextInt(SYMBOL.length);
            if (nextChar >= length) {
                sb.append(nextChar);
            } else if (nextChar <= SYMBOL.length) {
                sb.append(SYMBOL[nextChar]);
            } else {
                sb.append(nextChar);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1094().nextString(random, SYMBOL, length));
    }
}
