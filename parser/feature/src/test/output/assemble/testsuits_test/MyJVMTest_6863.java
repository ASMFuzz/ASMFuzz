public class MyJVMTest_6863 {

    static int a = -52506196;

    boolean test_isLeC(int a) {
        return a <= 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6863().test_isLeC(a));
    }
}
