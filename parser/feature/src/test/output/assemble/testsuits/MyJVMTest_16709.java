public class MyJVMTest_16709 {

    static int args = 8;

    int f(int... args) {
        return 6;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16709().f(args));
    }
}
