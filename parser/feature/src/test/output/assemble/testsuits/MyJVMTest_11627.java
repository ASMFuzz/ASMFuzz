public class MyJVMTest_11627 {

    static Object index = 4;

    String build(final Object index) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11627().build(index));
    }
}
