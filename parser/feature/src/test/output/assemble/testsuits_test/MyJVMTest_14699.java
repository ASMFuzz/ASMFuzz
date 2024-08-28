public class MyJVMTest_14699 {

    static T value = null;

    boolean isNull() {
        return value == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14699().isNull());
    }
}
