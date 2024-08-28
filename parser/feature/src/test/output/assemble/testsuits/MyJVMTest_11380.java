public class MyJVMTest_11380 {

    static int a = 3;

    int test_andc2(int a) {
        return a & 0x123456d5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11380().test_andc2(a));
    }
}
