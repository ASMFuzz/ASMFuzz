public class MyJVMTest_7186 {

    static int args = -698115442;

    int f(int... args) {
        return 6;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7186().f(args));
    }
}
