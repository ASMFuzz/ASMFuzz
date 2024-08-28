public class MyJVMTest_1568 {

    static boolean isArray = true;

    String brackets(boolean isArray) {
        return isArray ? "[]" : "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1568().brackets(isArray));
    }
}
