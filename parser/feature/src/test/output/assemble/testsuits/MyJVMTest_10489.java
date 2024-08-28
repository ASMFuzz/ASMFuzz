public class MyJVMTest_10489 {

    static String category = "Fg)8{nkn*u";

    boolean isLetter(String category) {
        return category.equals("Lu") || category.equals("Ll") || category.equals("Lt") || category.equals("Lm") || category.equals("Lo");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10489().isLetter(category));
    }
}
