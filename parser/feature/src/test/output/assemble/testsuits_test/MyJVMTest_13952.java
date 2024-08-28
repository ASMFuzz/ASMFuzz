public class MyJVMTest_13952 {

    String toHexString(int c) {
        return "0x" + Integer.toHexString(c);
    }

    static int MIN_SUPPLEMENTARY = 0x010000;

    static int MAX_SUPPLEMENTARY = 0x10ffff;

    void test00() {
        for (int cp = -MAX_SUPPLEMENTARY; cp <= MAX_SUPPLEMENTARY * 2; cp++) {
            boolean isValid = cp >= 0 && cp <= MAX_SUPPLEMENTARY;
            if (Character.isValidCodePoint(cp) != isValid) {
                throw new RuntimeException("isValidCodePoint failed with " + toHexString(cp));
            }
            boolean isSupplementary = cp >= MIN_SUPPLEMENTARY && cp <= MAX_SUPPLEMENTARY;
            if (Character.isSupplementaryCodePoint(cp) != isSupplementary) {
                throw new RuntimeException("isSupplementaryCodePoint failed with " + toHexString(cp));
            }
            int len = Character.charCount(cp);
            if (isValid) {
                if ((isSupplementary && len != 2) || (!isSupplementary && len != 1)) {
                    throw new RuntimeException("wrong character length " + len + " for " + toHexString(cp));
                }
            } else if (len != 1 && len != 2) {
                throw new RuntimeException("wrong character length " + len + " for " + toHexString(cp));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13952().test00();
    }
}
