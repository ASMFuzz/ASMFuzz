public class MyJVMTest_15265 {

    static int a = 0;

    boolean test_isNeC(int a) {
        return a != 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15265().test_isNeC(a));
    }
}
