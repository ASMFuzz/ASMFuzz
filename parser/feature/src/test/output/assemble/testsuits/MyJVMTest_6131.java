public class MyJVMTest_6131 {

    static int index = 0;

    static String value = "=*|l/qYZ|w";

    String getValue() throws IllegalStateException {
        if (index != -1) {
            throw new IllegalStateException();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6131().getValue());
    }
}
