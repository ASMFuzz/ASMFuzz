public class MyJVMTest_12345 {

    static int x = -972497639;

    int test(int x) {
        return (x & -32) / 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12345().test(x));
    }
}
