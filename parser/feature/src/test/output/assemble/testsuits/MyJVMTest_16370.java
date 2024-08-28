public class MyJVMTest_16370 {

    static int a = 3;

    boolean test_isLeC(int a) {
        return a <= 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16370().test_isLeC(a));
    }
}
