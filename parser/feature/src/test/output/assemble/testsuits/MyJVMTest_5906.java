public class MyJVMTest_5906 {

    static String category = "sG\\4hLp[2p";

    boolean isLetter(String category) {
        return category.equals("Lu") || category.equals("Ll") || category.equals("Lt") || category.equals("Lm") || category.equals("Lo");
    }

    boolean isUnicodeIdentifierStart(String category) {
        return isLetter(category) || category.equals("Nl");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5906().isUnicodeIdentifierStart(category));
    }
}
