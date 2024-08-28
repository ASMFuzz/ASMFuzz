public class MyJVMTest_1655 {

    static Integer n = 3;

    boolean test(Integer n) {
        System.out.println("Override");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1655().test(n));
    }
}
