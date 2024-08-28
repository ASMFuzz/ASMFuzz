public class MyJVMTest_15600 {

    static int index = 0;

    static String value = "U.{mzU?B+^";

    String getValue() throws IllegalStateException {
        if (index != -1) {
            throw new IllegalStateException();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15600().getValue());
    }
}
