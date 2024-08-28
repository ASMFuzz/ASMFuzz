public class MyJVMTest_13864 {

    static long a = 0;

    long test_subc1(long a) {
        return a - 11;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13864().test_subc1(a));
    }
}
