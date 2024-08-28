public class MyJVMTest_865 {

    static int codePoint = 1996552696;

    static String category = "}\"y(EFY.0:";

    boolean isIdentifierIgnorable(int codePoint, String category) {
        if (category.equals("Cf")) {
            return true;
        } else {
            int a1 = Integer.parseInt("0000", 16);
            int a2 = Integer.parseInt("0008", 16);
            int b1 = Integer.parseInt("000E", 16);
            int b2 = Integer.parseInt("001B", 16);
            int c1 = Integer.parseInt("007F", 16);
            int c2 = Integer.parseInt("009F", 16);
            if ((codePoint > a1 && codePoint < a2) || (codePoint > b1 && codePoint < b2) || (codePoint > c1 && codePoint < c2) || (codePoint == a1 || codePoint == a2 || codePoint == b1 || codePoint == b2 || codePoint == c1 || codePoint == c2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_865().isIdentifierIgnorable(codePoint, category));
    }
}
