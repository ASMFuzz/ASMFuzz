public class MyJVMTest_6626 {

    static int a = 513638170;

    boolean test_isEqC(int a) {
        return a == 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6626().test_isEqC(a));
    }
}
