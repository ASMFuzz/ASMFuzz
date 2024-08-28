public class MyJVMTest_6627 {

    static int a = 0;

    int test_ushrc1(int a) {
        return a >>> 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6627().test_ushrc1(a));
    }
}
