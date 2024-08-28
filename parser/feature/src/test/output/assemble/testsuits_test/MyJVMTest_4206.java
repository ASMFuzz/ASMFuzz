public class MyJVMTest_4206 {

    static Number n = null;

    boolean test(Number n) {
        System.out.println("Override");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4206().test(n));
    }
}
