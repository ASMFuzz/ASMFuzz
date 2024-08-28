public class MyJVMTest_17479 {

    static String category = "~N^A]M8cA$";

    boolean isSpaceChar(String category) {
        return category.equals("Zs") || category.equals("Zl") || category.equals("Zp");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17479().isSpaceChar(category));
    }
}
