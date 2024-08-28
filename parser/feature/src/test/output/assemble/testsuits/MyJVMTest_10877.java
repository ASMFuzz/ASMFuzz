public class MyJVMTest_10877 {

    static Integer n = -1252637668;

    boolean test(Integer n) {
        System.out.println("Override");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10877().test(n));
    }
}
