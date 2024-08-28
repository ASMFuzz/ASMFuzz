public class MyJVMTest_12132 {

    static int codePoint = 300687142;

    static String category = "S`4MJwasao";

    boolean isSpaceChar(String category) {
        return category.equals("Zs") || category.equals("Zl") || category.equals("Zp");
    }

    boolean isWhitespace(int codePoint, String category) {
        if (isSpaceChar(category) && codePoint != Integer.parseInt("00A0", 16) && codePoint != Integer.parseInt("2007", 16) && codePoint != Integer.parseInt("202F", 16)) {
            return true;
        } else {
            if (codePoint == Integer.parseInt("0009", 16) || codePoint == Integer.parseInt("000A", 16) || codePoint == Integer.parseInt("000B", 16) || codePoint == Integer.parseInt("000C", 16) || codePoint == Integer.parseInt("000D", 16) || codePoint == Integer.parseInt("001C", 16) || codePoint == Integer.parseInt("001D", 16) || codePoint == Integer.parseInt("001E", 16) || codePoint == Integer.parseInt("001F", 16)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12132().isWhitespace(codePoint, category));
    }
}
