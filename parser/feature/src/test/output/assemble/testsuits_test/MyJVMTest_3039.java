public class MyJVMTest_3039 {

    static int x = 3;

    int test(int x) {
        return (x & -32) / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3039().test(x));
    }
}
