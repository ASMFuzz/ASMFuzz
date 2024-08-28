public class MyJVMTest_13346 {

    static int ch = -1049670231;

    boolean isPunct(int ch) {
        return ((((1 << Character.CONNECTOR_PUNCTUATION) | (1 << Character.DASH_PUNCTUATION) | (1 << Character.START_PUNCTUATION) | (1 << Character.END_PUNCTUATION) | (1 << Character.OTHER_PUNCTUATION) | (1 << Character.INITIAL_QUOTE_PUNCTUATION) | (1 << Character.FINAL_QUOTE_PUNCTUATION)) >> Character.getType(ch)) & 1) != 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13346().isPunct(ch));
    }
}
