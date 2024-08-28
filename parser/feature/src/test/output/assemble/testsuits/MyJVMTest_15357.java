public class MyJVMTest_15357 {

    static String category = "Q)fi7%.fLt";

    boolean isLetter(String category) {
        return category.equals("Lu") || category.equals("Ll") || category.equals("Lt") || category.equals("Lm") || category.equals("Lo");
    }

    boolean isUnicodeIdentifierStart(String category) {
        return isLetter(category) || category.equals("Nl");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15357().isUnicodeIdentifierStart(category));
    }
}
