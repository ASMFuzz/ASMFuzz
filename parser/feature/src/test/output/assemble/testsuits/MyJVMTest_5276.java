public class MyJVMTest_5276 {

    static T value = null;

    boolean isNull() {
        return value == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5276().isNull());
    }
}
