public class MyJVMTest_7496 {

    static String category = "US#n4iTb_l";

    boolean isLetter(String category) {
        return category.equals("Lu") || category.equals("Ll") || category.equals("Lt") || category.equals("Lm") || category.equals("Lo");
    }

    boolean isJavaIdentifierStart(String category) {
        return isLetter(category) || category.equals("Nl") || category.equals("Sc") || category.equals("Pc");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7496().isJavaIdentifierStart(category));
    }
}
