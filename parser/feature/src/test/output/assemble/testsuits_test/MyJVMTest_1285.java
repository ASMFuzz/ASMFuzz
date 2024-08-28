public class MyJVMTest_1285 {

    static String category = "e\\ri[PZ.0-";

    boolean isLetter(String category) {
        return category.equals("Lu") || category.equals("Ll") || category.equals("Lt") || category.equals("Lm") || category.equals("Lo");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1285().isLetter(category));
    }
}
