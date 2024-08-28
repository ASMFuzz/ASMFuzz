public class MyJVMTest_7917 {

    static String category = "]r>S.${rg<";

    boolean isSpaceChar(String category) {
        return category.equals("Zs") || category.equals("Zl") || category.equals("Zp");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7917().isSpaceChar(category));
    }
}
