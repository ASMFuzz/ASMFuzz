public class MyJVMTest_10046 {

    static Object[][] charData = { { new Character('\uFFFE'), Character.UnicodeBlock.SPECIALS }, { new Character('\uFFFF'), Character.UnicodeBlock.SPECIALS } };

    void run() {
        Character ch;
        Character.UnicodeBlock block;
        for (int x = 0; x < charData.length; x++) {
            ch = (Character) charData[x][0];
            block = (Character.UnicodeBlock) charData[x][1];
            if (Character.UnicodeBlock.of(ch.charValue()) != block) {
                System.err.println("Error: block = " + block);
                System.err.println("Character.UnicodeBlock.of(" + Integer.toHexString(ch.charValue()) + ") = " + Character.UnicodeBlock.of(ch.charValue()));
                throw new RuntimeException("Blocks aren't equal.");
            }
        }
        System.out.println("Passed.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10046().run();
    }
}
