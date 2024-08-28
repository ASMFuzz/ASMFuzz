public class MyJVMTest_10788 {

    static boolean isArray = false;

    String brackets(boolean isArray) {
        return isArray ? "[]" : "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10788().brackets(isArray));
    }
}
